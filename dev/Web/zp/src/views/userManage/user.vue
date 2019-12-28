/*
 * @Author: liuyr 
 * 用户列表页面
 * @Date: 2019-12-23 17:11:53 
 * @Last Modified by: liuyr
 * @Last Modified time: 2019-12-23 21:05:54
 */
 11111
<template>
    <div id="userList"> 
      <div class="zengjiadaoru">
        <el-button @click="toAdd" type="primary" plain>添加用户</el-button>
        <el-button type="success" plain>导入用户</el-button>
        <br>
        <br>  
      </div>
      
      <div class="searchDiv">
        <el-select @change="educationChange" size="mini" v-model="education" clearable placeholder="学历">
          <el-option v-for="item in educationData" :key="item" :label="item" :value="item"></el-option>
        </el-select>
        <el-select @change="genderChange" size="mini" v-model="gender" clearable placeholder="性别">
          <el-option v-for="item in genderData" :key="item" :label="item" :value="item"></el-option>
        </el-select>
      </div>
      <div class="Selete" style="margin-top: -30px; width:300px; float:right; ">
        <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
            <el-select v-model="input3" slot="prepend" placeholder="请选择">
            </el-select>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </div>
        <div class="tableDiv">
          <el-table
              ref="multipleTable"
              :data="userList"
              tooltip-effect="dark"
              style="width: 100%"
              @selection-change="selectionChange">
              <el-table-column
                align="center"
                type="selection"
                width="55">
              </el-table-column>
              <el-table-column
                align="center"
                prop="id"
                label="id"
                width="120">
              </el-table-column>
              <el-table-column
                align="center"
                prop="username"
                label="用户名"
                width="120">
              </el-table-column>
              <el-table-column
                align="center"
                prop="realname"
                label="姓名"
                width="120">
                <!-- <template slot-scope="scope">{{ scope.row.date }}</template> -->
              </el-table-column>
              <el-table-column
                align="center"
                prop="telephone"
                label="手机号"
                width="120">
              </el-table-column>
              <el-table-column
                align="center"
                prop="gender"
                label="性别"
                show-overflow-tooltip>
              </el-table-column>
              <el-table-column
                align="center"
                prop="birth"
                label="出生年月"
                show-overflow-tooltip>
              </el-table-column>
              <el-table-column
                align="center"
                prop="education"
                label="最高学历"
                show-overflow-tooltip>
              </el-table-column>
            <el-table-column  label="操作" width="100">
              <template slot-scope="scope">
                <el-button  @click="toEdit(scope.row)" type="text" size="small">修改</el-button>
                <el-button type="text" size="small" @click="toDelete(scope.row.id)">删除</el-button>
              </template>
            </el-table-column>
           </el-table>
        </div>
        <div class="footerDiv">
      <div class="btnDiv">
        <el-button @click="toBatchDelete" size="mini" type="danger" plain>批量删除</el-button>
      </div>
    </div>
            <div class="pagi">
              <el-pagination
                @current-change="currentChange"
                :current-page.sync="currentPage"
                size="mini"
                background
                layout="prev, pager, next"
                :total="JobhunterData.length"
              ></el-pagination>
            </div>
            
            <el-dialog title="dialogTitle" :visible.sync="dialogFormVisible">
          <el-form :model="saveOrUpdateData">
            <!-- <el-form-item label="id号" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.id" auto-complete="off"></el-input>
            </el-form-item> -->
            <el-form-item label="用户名" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.username" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="姓名" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.realname" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="手机号" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.telephone" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.gender" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="出生年月" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.birth" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="最高学历" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.education" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="求职状态" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.currentStatus" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.password" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="简历" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.resume" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="工作时间" :label-width="formLabelWidth">
              <el-input v-model="saveOrUpdateData.workTime" auto-complete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="toSave()">确 定</el-button>
          </div>
        </el-dialog>

        
    </div>
</template>

<script>
// import qs from "qs";
// import axios from "axios";
// axios.defaults.baseURL = "http://127.0.0.1:8899";
import { findAllJobhunter } from "@/api/user.js";
import { saveOrUpdate } from "@/api/user.js";
import config from "@/utils/config.js";
import { JobhunterdeleteById } from "@/api/user.js";
import { findJobhunterByEducation } from "@/api/user.js";
import { findJobhunterByGender } from "@/api/user.js";



export default {
  name: "userList",
  data() {
    return {
      dialogTitle:"添加信息",
      //修改模态框汉字的宽度
      formLabelWidth: "120px",
      //模态框的显示与否
      dialogFormVisible:false,
      
      //当前页
      currentPage: 1,
      //id
      id:'',
      //所有信息
      Jobhunter:'',
      //用户名
      username:'',
      //姓名
      realname:'',
      //手机号
      telephone:'',
      //性别
      gender:'',
      //出生年月
      birth:'',
      //  学历
      education:'',
      input3:'',
      //id信息数据
      idData:[],
      //批量删除ids
      ids: [],
      //所有信息数据
      JobhunterData:[],
      //用户名数据
      usernameData: [],
      //姓名数据
      realnameData: [],
      //手机号数据
      telephoneData: [],
      //性别数据
      genderData: [],
      //出生年月数据
      birthData: [],
      //学历数据
      educationData: [],

      saveOrUpdateData:[],
      Jobhunter:{
        birth:'',
        id:'',
        username:'',
        realname:'',
        telephone:'',
        gender:'',
        birth:'',
        education:'',
      },
      //校验规则
      rules: {
        username: [{ required: true, message: "请输入用户名", trigger: "blur" }],
        realname: [
          { required: true, message: "请输入真实姓名", trigger: "blur" }
        ],
        telephone: [{ required: true, message: "请输入手机号", trigger: "blur" }],
        gender: [
          { required: true, message: "请输入性别", trigger: "blur" }
        ],
        birth: [
          { required: true, message: "请输入出生年月", trigger: "blur" }
        ],
        education: [
          { required: true, message: "请输入学历", trigger: "blur" }
        ],
        workTime: [
          { required: true, message: "请输入工作时间", trigger: "blur" }
        ],
        resume: [
          { required: true, message: "请输入简历", trigger: "change" }
        ],
      currentStatus: [{ required: true, message: "请输入求职状态", trigger: "change" }]
        // city: [{ required: true, message: "请输入密码", trigger: "change" }],
        // city: [{ required: true, message: "请输入密码", trigger: "change" }]
      }
    };
  },
  computed: {
    userList() {
      //  分页数据
      let temp = [...this.fenlei2()];
      let pageSize = 10;
      let page = this.currentPage;       
      return temp.slice((page - 1) * pageSize, page * pageSize);
      
    }
  },
  methods: {
    //新增按钮
    toAdd(row) {
      this.dialogTitle = "添加信息";
      this.saveOrUpdateData = row;
      this.dialogFormVisible = true;
      this.findAllJob();
    },
    //c查找
      fenlei2 () {
        const search =this.input3;
        if (search) {
           // filter() 方法创建一个新的数组，新数组中的元素是通过检查指定数组中符合条件的所有元素。
           // 注意： filter() 不会对空数组进行检测。
           // 注意： filter() 不会改变原始数组。
           return this.JobhunterData.filter(data => {
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
         return this.JobhunterData;
       },
  
    // 页数发生改变
    pageChange(page) {
      this.currentPage = page;
    },
    //学历信息发生改变
    async educationChange(val) {
      // console.log('----'+val);
      // this.id = "";
      // this.gender = "";
      // this.username = "";
      // this.realname = "";
      // this.telephone = "";
      // this.birth = "";
      // this.education = "";
      // this.scale = "";
      //val 是option的value值
      if (val) {
        try {
          let res = await findJobhunterByEducation({education:val});
          // console.log(res);
          this.JobhunterData = res.data;
          // console.log(res);
          
          // this.currentPage = 1;
        } catch (error) {
          config.errorMsg(this, "通过学历信息查找信息错误");
        }
      } else {
        this.findAllJob();
      }
    },
    //性别信息发生改变
    async genderChange(val) {
      // this.gender = "";
      this.education = "";
      this.id = "";
      // this.gender = "";
      this.username = "";
      this.realname = "";
      this.telephone = "";
      this.birth = "";
      this.education = "";
      // this.industry = "";
      //val 是option的value值
      if (val) {
        try {
          let res = await findJobhunterByGender({ gender: val });
          this.JobhunterData = res.data;
          this.currentPage = 1;
        } catch (error) {
          config.errorMsg(this, "通过性别查找信息错误");
        }
      } else {
        this.findAllJob();
      }
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
                  let res = await JobhunterdeleteById({ id: id });
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
                this.findAllJob();
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
            let res = await JobhunterdeleteById({ id: id });
            if (res.status === 200) {
              config.successMsg(this, "删除成功");
              this.findAllJob();
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
    //保存
    async toSave(){
      try {
        let res = await saveOrUpdate(this.saveOrUpdateData);
        this.dialogFormVisible = false;
        this.findAllJob();
        this.$notify({
          title: "成功",
          message: "保存成功",
          type: "success"
        });
      } catch (error) {
        console.log(error);
      }
     },
    //修改按钮
    toEdit(row) {
      this.dialogTitle = "修改信息";
      this.saveOrUpdateData = row;
      this.dialogFormVisible = true;
      // console.log(row);
      // console.log(this.saveOrUpdateData);
      
      
      // this.saveOrUpdateData();
    },
    currentChange(val) {
      //val是当前点击的页数
      // console.log(val);
      this.currentPage = val;
    },
    //查找所有数据
    async  findAllJob () {
      try {
        let res = await findAllJobhunter();
        let temp = res.data;
        // setTimeout(() => {
        //   this.JobhunterData = temp;
        // },2000);

        //学历去重
         this.JobhunterData = temp
        let educationArr = res.data.map(item => {
          return item.education;
        });
        //去重
        this.educationData = [...new Set(educationArr)];
        console.log(this.JobhunterData);
            console.log(this.educationData);
           
           
           //性别去重
            this.JobhunterData = temp
        let genderArr = res.data.map(item => {
          return item.gender;
        });
        //去重
        this.genderData = [...new Set(genderArr)];
        console.log(this.JobhunterData);
            console.log(this.genderData);
        
      }
      catch(err){
        console.log(err);
      }
    },

  },
  created() {
    this.findAllJob();
  
    // this.toDelete();
  },
  mounted() {}
};
</script>
<style lang="scss" scoped>
#userList { 
  .userList-table {
    margin-top: 10px;
    border-top: 1px solid #ebeef5;
    .iconDiv {
      margin-right: 10px;
    }
    .iconDiv:last-child {
      margin-right: 0;
    }
  }
  .pagi {
  text-align: right;
  margin-top: 10px;
 }
  // .zengjiadaoru{
  //   // float: right;
  //   // margin-top: px
  // }
}

</style>
