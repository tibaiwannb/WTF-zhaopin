/*
 * @Author: liuyr 
 * 城市管理页面
 * @Date: 2019-12-23 17:11:53 
 * @Last Modified by: lixf
 * @Last Modified time: 2019-12-29 00:09:42
 */
<template>
  <div id="moduleCity">
    <!-- {{this.province}} -->
    <div>

      <el-button @click="toAdd1" size="small" type="primary" round>新增省份</el-button>
      <el-button @click="toAdd" size="small" type="success" round>新增城市</el-button>
      <br />
      <br />

      <el-table :data="provinceData">
        
        <el-table-column  type="expand" prop="city">
          <template slot-scope="scope" >
            <el-table  :data="scope.row.city" >
                <el-table-column prop="name" label="城市"  align="left">
                  <template slot-scope="scope">
                      <span>{{scope.row.name}}</span>
                    </template>
                </el-table-column>

                <el-table-column align="right" label="操作" width="100">
                  <template slot-scope="scope">
                    <el-button type="text" @click="toEdit(scope.row)" size="small">编辑</el-button>
                    <el-button type="text" size="small" @click="toDelete(scope.row.id)">删除</el-button>
                  </template>
                </el-table-column>

            </el-table>
          </template>
        </el-table-column>

        <el-table-column prop="name" label="省份"  align="left" >
          <template slot-scope="scope">
            <span>{{scope.row.name}}</span>
          </template>
        </el-table-column>

        <el-table-column align="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button type="text" @click="toEdit1(scope.row)" size="small">编辑</el-button>
            <el-button type="text" size="small" @click="toDelete1(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>

      </el-table>

      <!-- 冒号:修饰的要在return数据模型里给值   这个是模态框 -->
      <el-dialog :title="diologTitle" :visible.sync="dialogFormVisible"> 
        <el-form :model="province">
          <el-form-item label="城市名称" :label-width="formLabelWidth"> 
            <el-input v-model="province.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="所属省份" :label-width="formLabelWidth">
              <el-select v-model="province.provinceId" placeholder="请选择所属省份">
                <!-- <el-option label="请从下列的省份中选择" value></el-option> -->
                <el-option 
                v-for="(item,index) in provinceData" 
                :key="index" 
                :label="item.name" 
                :value="item.id">
                </el-option>
                </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="toSave">确 定</el-button>
        </div>
      </el-dialog>

      <el-dialog :title="diologTitle1" :visible.sync="dialogFormVisible1"> 
        <el-form :model="province">
          <el-form-item label="省份名称" :label-width="formLabelWidth"> 
            <el-input v-model="province.name" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="toSave1">确 定</el-button>
        </div>
      </el-dialog>

    </div>
  </div>
</template>

<script>
import { findAllProvince,deleteProvinceById,saveOrUpdateProvince } from "@/api/province.js";
import { findAllCity,findCityByProvinceId,saveOrUpdateCity,deleteCityById } from "@/api/city.js";
import config from "@/utils/config.js";

export default {
  data() {
    return {
 
      provinceData:[],

      //模态框显示与隐藏（false隐藏）
      dialogFormVisible:false,
      dialogFormVisible1:false,
      diologTitle:"新增城市",
      diologTitle1:"新增省份",
      //表单左侧的文字宽度
      formLabelWidth:"120px",

      province:{
        provinceId:'',
        name:''
      }
      
    };
  },
  computed: {},
  methods: {
    //查找所有省份，获取省份id,以省份id找到省份所含城市
    async findAllPro(page){
      try{
        let res = await findAllProvince();
        let temp = [...res.data];
        temp.forEach(async (item)=>{
          let id = item.id;
          let resp = await findCityByProvinceId({provinceId:id})
          //console.log(resp);
          item.city = resp.data;
        })
        setTimeout(()=>{
          this.provinceData = temp;
        },100)
      }catch(err){
        this.$notify.error({
          title: "错误",
          message: "查找失败"
        });
      }
    },

    //新增按钮
    toAdd(){
      this.diologTitle="新增城市";
      this.province = {};
      this.dialogFormVisible = true     //模态框显示
      this.findAllPro();       
    },

    //保存
    async toSave(){
      try {
        let res = await saveOrUpdateCity(this.province); 
        // console.log(res);
        this.dialogFormVisible = false;   //保存成功，模态框隐藏
        this.findAllPro();
        this.$notify({
            title: "成功",
            message: "保存成功",
            type: "success"
          });
      }catch(err){
        config.errorMsg(this, "城市或省份名字为空");
      }
    },

    //删除
    async toDelete(id){
      try {
        let res = await deleteCityById({ id: id }); 
        // console.log(res);
        this.findAllPro();
        this.$notify({
            title: "成功",
            message: "删除成功",
            type: "success"
          });
      }catch(err){
        console.log(err);
      }
    },

    //编辑按钮
    toEdit(row){
      this.diologTitle="编辑城市信息";
      //{...row}   把row展开，然后放到一个新的数组中(复制，使row不是同一个地址)
      this.province = {...row};
      // delete this.province.name;
      // console.log(this.province.name);
      this.dialogFormVisible = true
      // this.findAllPro();  
    },

    //新增按钮1
    toAdd1(){
      this.diologTitle1="新增省份";
      this.province = {};
      this.dialogFormVisible1 = true   ;
      this.findAllPro();       
    },

    //保存1
    async toSave1(){
      try {
        let res = await saveOrUpdateProvince(this.province); 
        // console.log(res);
        this.dialogFormVisible1 = false;   //保存成功，模态框隐藏
        this.findAllPro();
        this.$notify({
            title: "成功",
            message: "保存成功",
            type: "success"
          });
      }catch(error){
        config.errorMsg(this, "省份名字不能为空");
      }
    },

    //删除1
    toDelete1(id) {
      // alert("删除");
      this.$confirm("是否删除该记录?", "提示", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(async () => {
          //访问后台接口
          try {
            let res = await deleteProvinceById({ id: id });
            if (res.status === 200) {
              config.successMsg(this, "删除成功");
              this.findAllPro();
            } else {
              config.errorMsg(this, "删除失败");
            }
          } catch (error) {
            config.errorMsg(this, "删除失败");
          }
        })
        .catch((error) => {
          console.log(error,'-----');
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },

    //编辑按钮1
    toEdit1(row){
      this.diologTitle1="编辑省份信息";
      //{...row}   把row展开，然后放到一个新的数组中(复制，使row不是同一个地址)
      this.province = {...row};
      // delete this.province.name;
      // console.log(this.province.name);
      this.dialogFormVisible1 = true
      // this.findAllPro();  
    },
    


  },
  created() {
    // this.findAllCi();
    this.findAllPro();
    // this.toSave();
    // this.findCityByPId();
    // this.findCityByProvinceId();
  },
  mounted() {}
};
</script>
<style scoped>
</style>
