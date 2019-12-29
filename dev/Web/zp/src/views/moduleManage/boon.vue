/*
 * @Author: liuyr 
 * 福利管理页面
 * @Date: 2019-12-23 17:11:53 
 * @Last Modified by: lixf
 * @Last Modified time: 2019-12-29 00:34:26
 */
<template>
  <div id="moduleBoon">
    <!-- {{WelfareData}} -->
    <div class="tableDiv">

      <el-input v-model="input" placeholder="请输入要查找的内容"></el-input>
      <br />
      <br />

      <el-table ref="multipleTable" :data="WelfareList" tooltip-effect="dark" style="width: 100%" @selection-change="selectionChange">
        <el-table-column align="center" type="selection" width="55"></el-table-column>
        <el-table-column align="center" prop="id" label="福利编号"></el-table-column>
        <el-table-column align="center" prop="name" label="福利内容"></el-table-column>
        <el-table-column align="center" prop="status" label="福利状态">
          <template slot-scope="scope">
            <div v-html="scope.row.status" v-if="scope.row.status == '使用中'" style="color:#67C23A"></div>
            <div v-html="scope.row.status" v-if="scope.row.status == '冻结中'" style="color:#F56C6C"></div>
          </template>
        </el-table-column>
        
        <el-table-column align="center" label="状态操作" width="200">
          <template slot-scope="scope">
            <el-button size="mini" type="success" @click="changeStatus_1(scope.row)">使用</el-button>
            <el-button size="mini" type="danger" @click="changeStatus_2(scope.row)">冻结</el-button>
          </template>
        </el-table-column>

        <el-table-column align="center" label="整体操作" width="100">
          <template slot-scope="scope">
            <el-button type="text" @click="toEdit(scope.row)" size="small">编辑</el-button>
            <el-button type="text" size="small" @click="toDelete(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div>

        <div class="btnDiv">
        <el-button @click="toBatchDelete" size="mini" type="danger" plain>批量删除</el-button>
        </div>

        <div class="pageDiv">
          <el-pagination
            :page-size="pageSize"
            :current-page.sync="currentPage"
            background
            @current-change="pageChange"
            layout="prev, pager, next"
            :total="WelfareData.length">
          </el-pagination>
        </div>
      </div>

      <!-- 冒号:修饰的要在return数据模型里给值   这个是模态框 -->
      <el-dialog :title="diologTitle" :visible.sync="dialogFormVisible"> <!--:visible里的dialogFormVisible控制模态框(对话框)的显示与否 -->
        <el-form :model="Welfare">
          <el-form-item label="福利内容" :label-width="formLabelWidth"> 
            <el-input v-model="Welfare.name" placeholder="请输入要更改的内容" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="福利状态" :label-width="formLabelWidth"> 
            <el-input v-model="Welfare.status" placeholder="请输入使用中或被冻结" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="toSave">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { findAllWelfare,deleteWelfareById,findWelfareById,saveOrUpdateWelfare } from "@/api/boon.js";
import config from "@/utils/config.js";
export default {
  data() {
    return {
      WelfareData:[],
      Welfare:{
        name:'',
        status:''
      },
      input:'',
      //当前页
      currentPage: 1,
      //每页条数
      pageSize: config.pageSize,
      //模态框显示与隐藏（false隐藏）
      dialogFormVisible:false,
      diologTitle:"编辑福利",
      //表单左侧的文字宽度
      formLabelWidth:"120px",
      //批量删除ids
      ids: [],
    };
  },
  computed: {
    //分页数据
    WelfareList() {
      let temp = [...this.fenlei2 ()];
      let page = this.currentPage;
      let pageSize = config.pageSize;
      return temp.slice((page - 1) * pageSize, page * pageSize);
    }
  },
  methods: {

    // 页数发生改变
    pageChange(page) {
      this.currentPage = page;
    },

    //查找所有福利信息
    async findAllboon() {
      try {
        let res = await findAllWelfare();
        this.WelfareData = res.data;
      } catch (error) {
        config.errorMsg(this, "查找错误");
      }
    },


    //编辑按钮
    toEdit(row){
      this.diologTitle="编辑福利信息";
      //{...row}   把row展开，然后放到一个新的数组中(复制，使row不是同一个地址)
      this.Welfare = {...row};
      // delete this.Welfare.name;
      console.log(this.Welfare);
      this.dialogFormVisible = true
      this.findAllboon();  
    },

    //保存
    async toSave(){
      try {
        let res = await saveOrUpdateWelfare(this.Welfare); 
        // console.log(res);
        this.dialogFormVisible = false;
        this.findAllboon();
        this.$notify({
            title: "成功",
            message: "保存成功",
            type: "success"
          });
      }catch(err){
        console.log(err);
      }
    },

    //删除
    toDelete(id) {
      // alert("删除");
      this.$confirm("是否删除该记录?", "提示", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(async () => {
          //访问后台接口
          try {
            let res = await deleteWelfareById({ id: id });
            if (res.status === 200) {
              config.successMsg(this, "删除成功");
              this.findAllboon();
            } else {
              config.errorMsg(this, "删除失败");
            }
          } catch (error) {
            config.errorMsg(this, "删除失败");
          }
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },

    //批量删除
    toBatchDelete() {
      //获取要批量删除的id  this.ids
      let ids = this.ids;
      if (ids.length > 0) {
        this.$alert("是否删除？", "提示", {
          confirmButtonText: "删除",
          callback: action => {
            if (action === "confirm") {
              let result = [];
              ids.forEach(async id => {
                try {
                  let res = await deleteWelfareById({ id: id });
                  result.push(res.status);
                } catch (error) {
                  result.push(500);
                }
              });
              setTimeout(() => {
                // console.log(result);
                //判断是否都是200
                let resu = result.every(item => {
                  return item === 200;
                });
                if (resu) {
                  config.successMsg(this, "批量删除成功");
                } else {
                  config.errorMsg(this, "批量删除失败");
                }
                this.findAllboon();
              }, 2000);
            }
          }
        });
      } else {
        this.$message({
          message: "请选中要删除的数据",
          type: "warning"
        });
      }
    },
    //复选框选中切换
    selectionChange(val) {
      //val 就是选中的对象组成的数组
      // console.log(val);
      let ids = val.map(item => {
        return item.id;
      });
      this.ids = ids;
    },

    fenlei2 () {
        const search =this.input;
        if (search) {
           // filter() 方法创建一个新的数组，新数组中的元素是通过检查指定数组中符合条件的所有元素。
           // 注意： filter() 不会对空数组进行检测。
           // 注意： filter() 不会改变原始数组。
           return this.WelfareData.filter(data => {
           // some() 方法用于检测数组中的元素是否满足指定条件;
             // some() 方法会依次执行数组的每个元素：
            // 如果有一个元素满足条件，则表达式返回true , 剩余的元素不会再执行检测;
             // 如果没有满足条件的元素，则返回false。
             // 注意： some() 不会对空数组进行检测。
             // 注意： some() 不会改变原始数组。
             return Object.keys(data).some(key => {
               // indexOf() 返回某个指定的字符在某个字符串中首次出现的位置，如果没有找到就返回-1；
               // 该方法对大小写敏感！所以之前需要toLowerCase()方法将所有查询到内容变为小写。
               return String(data[key]).toLowerCase().indexOf(search) > -1
             })
           })
        }
         return this.WelfareData;
       },

       async changeStatus_1(row){
        // console.log(row)
        let name = row
        if(name.status == '冻结中'){
        try {
          // let res = await this.$store.dispatch("FindAllCity");
          name.status = '使用中'
          console.log(name)
          let res = await saveOrUpdateWelfare(name);

          // this.findAllPro();
          this.$notify({
              title: "成功",
              message: "保存成功",
              type: "success"
            });
        } 
        catch (err) {
          this.$notify.error({
            title: "错误",
            message: "查找失败"
          });
        }
      }else{this.$notify.error({
            title: "错误",
            message: "状态已为'使用中'"
          });}
      },

      async changeStatus_2(row){
        // console.log(row)
        let name = row
        if(name.status == '使用中'){
        try {
          // let res = await this.$store.dispatch("FindAllCity");
          name.status = '冻结中'
          console.log(name)
          let res = await saveOrUpdateWelfare(name);

          // this.findAllPro();
          this.$notify({
              title: "成功",
              message: "保存成功",
              type: "success"
            });
        } 
        catch (err) {
          this.$notify.error({
            title: "错误",
            message: "查找失败"
          });
        }
      }else{this.$notify.error({
            title: "错误",
            message: "状态已为'冻结中'"
          });}
      },

  },
  created() {
    this.findAllboon();
  },
  mounted() {}
};
</script>
<style scoped>
.footerDiv {
  overflow: hidden;
  margin-top: 10px;
}
.btnDiv {
    float: left;
  }
.pageDiv {
    float: right;
  }
</style>
