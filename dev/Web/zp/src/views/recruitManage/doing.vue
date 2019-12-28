/*
 * @Author: liuyr 
 * 招聘中页面
 * @Date: 2019-12-23 17:03:30 
 * @Last Modified by: littorio
 * @Last Modified time: 2019-12-28 11:35:46
 */
<template>

  <div>
    <!-- 头 -->
    
    <div class="searchDiv">
      <div class="searchL" >
      <el-select @change="jobChange" size="mini" v-model="job" clearable placeholder="职业类型" style="float: left; margin-top:18px; ">
        <el-option
          v-for="item in EmploymentData"
          :key="item.id"
          :label="item.job"
          :value="item.job"
        ></el-option>
      </el-select>
    </div>
    <div class="searchR">
    <el-input placeholder="请输入内容" v-model="input3" class="input-with-select" style="width:300px; float:right; margin-top: 15px; " clearable>
    <el-select v-model="select" slot="prepend" placeholder="请选择">
      <el-option label="餐厅名" value="1"></el-option>
      <el-option label="订单号" value="2"></el-option>
      <el-option label="用户电话" value="3"></el-option>
    </el-select>
    <el-button @click="fenlei2" slot="append" icon="el-icon-search"></el-button>
  </el-input>
 </div>
 </div>
 
    <div class="a">
    <el-button @click="toAdd" size =  "mini" type="primary">发布职位</el-button> 
    <el-button size =  "mini" type="primary">导入职位</el-button>
    </div>

    <el-table size = 'mini' 
      :data="EmploymentList"
      tooltip-effect="dark"
        
      @selection-change="selectionChange"
      style="width: 100%">  
    <el-table-column
      type="selection"
      width="55"
      align="center">
    </el-table-column>
    <el-table-column
      prop="id"
      label="编号"
      align="center">
    </el-table-column>
    <el-table-column
      prop="title"
      label="招聘标题"
      align="center">
    </el-table-column>
    <el-table-column
      prop="contactName"
      label="发布人"
      align="center">
    </el-table-column>
    
    <el-table-column
      prop="contactPhone"
      label="联系方式"
      align="center">
    </el-table-column>
    
    <el-table-column
      prop="job"
      label="职位"
      align="center">
    </el-table-column>

    <el-table-column
      prop="publishTime"
      label="发布时间"
      align="center">
    </el-table-column>
    <el-table-column align="center" label="详情">
          <template slot-scope="scope">
            <el-button @click="toSee(scope.row)" type="text" size="small">查看</el-button>
          </template>
        </el-table-column>
    <el-table-column
      prop="操作"
      label="操作"
      align="center">
      <template slot-scope="scope">
        <el-button @click="toDelete(scope.row)" type="text" size="small">删除</el-button>
        <el-button @click="toEdit(scope.row)" type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
    
    
  </el-table>
   
    <!--弹窗-->

<el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible" width="60%" :before-close="beforeClose">
  <el-form :model="Employment" :rules="rules" ref="ruleForm"> 
  <!-- 第一行 -->
  <el-form-item prop="title" label="兼职名称" :label-width="formLabelWidth">
      <el-input v-model="Employment.title" auto-complete="off"></el-input>
    </el-form-item>
    
  <!-- 第二行 -->
  <el-row :gutter="20">
    <el-col :span="12"><div class="grid-content bg-purple">
      <el-form-item prop="job" label="选择工种" :label-width="formLabelWidth">
      <el-select v-model="Employment.job" placeholder="请选择活动区域">
        
        <el-option v-for="(item ,index) in jobData" :key="index" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item></div>
    </el-col>

    <el-col :span="12"><div class="grid-content bg-purple-light">
     <el-form-item prop="num" label="招聘人数" :label-width="formLabelWidth">
      <el-input v-model="Employment.num" auto-complete="off"></el-input>
    </el-form-item> 
      </div></el-col>
  </el-row>
  <!-- 第三行 -->
     <el-row :gutter="20">
        <el-col :span="12"><div class="grid-content bg-purple">
          <el-form-item prop="businessId" label="招聘公司" :label-width="formLabelWidth">
      <el-select clearable @change="dialogBusChange" v-model="Employment.businessId" placeholder="请选择活动区域">
       
        <el-option v-for="(item ,index) in BusinessData" :key="index" :label="item.name" :value="item.id"></el-option>
      </el-select>
      </el-form-item></div></el-col>
      
        <el-col :span="12"><div class="grid-content bg-purple-light">
          <el-form-item prop="salary" label="薪资水平" :label-width="formLabelWidth">
      <el-input v-model="Employment.salary" auto-complete="off"></el-input>
     </el-form-item></div></el-col>
    </el-row>
    
    <!-- 第四行 -->
    <el-form-item prop="welfare" label="福利" :label-width="formLabelWidth">
      <el-input  v-model="Employment.welfare" auto-complete="off"></el-input>
    </el-form-item>
    <!-- 第五行 -->
    <el-row :gutter="20">
      <el-col :span="12"><div class="grid-content bg-purple">
      <el-form-item prop="status" label="发布状态" :label-width="formLabelWidth">
        <el-input v-model="Employment.status" auto-complete="off"></el-input>
      </el-form-item></div></el-col>
      

      <el-col :span="12"><div class="grid-content bg-purple-light">
        <el-form-item prop="workingHours" label="工作时间" :label-width="formLabelWidth">
      <el-select v-model="Employment.workingHours" placeholder="请选择活动区域">
        <el-option label="区域一" value="shanghai"></el-option>
        <el-option v-for="(item ,index) in EmploymentData" :key="index" :label="item.workingHours" :value="item.workingHours"></el-option>
      </el-select>
    </el-form-item></div></el-col>
    </el-row>
    <!-- 地六航 -->

    <el-row :gutter="20">
      
      <el-col :span="12"><div class="grid-content bg-purple">
        <el-form-item prop="contactName" label="姓名" :label-width="formLabelWidth">
      <el-select v-model="Employment.contactName" placeholder="请选择姓名">
        
        <el-option v-for="(item ,index) in findNPbybusData" :key="index" :label="item.contactName" :value="item.contactName"></el-option>
      </el-select>
    </el-form-item></div></el-col>
      <el-col :span="12"><div class="grid-content bg-purple-light">
        <el-form-item prop="contactPhone" label="电话" :label-width="formLabelWidth">
      <el-select v-model="Employment.contactPhone" placeholder="请选择电话">
        
        <el-option v-for="(item ,index) in findNPbybusData" :key="index" :label="item.contactPhone" :value="item.contactPhone"></el-option>
      </el-select>
    </el-form-item></div></el-col>
    </el-row>
    <!-- 第7行 -->
    
    <el-form-item prop="description" label="职位描述">
      <el-input  type="textarea" v-model="Employment.description" ></el-input>
    </el-form-item>  
    
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button size = "mini" @click="toCancel('ruleForm')">取 消</el-button>
    <el-button size = "mini" type="primary" @click="toSave('ruleForm')">确 定</el-button>
  </div>
</el-dialog>
<!-- 查看模态框 -->
    <el-dialog :title="Employment.title" :visible.sync="seeVisible">
      <div class="top">
      <div>
        <span><i class="el-icon-location-outline"> {{Employment.province}}</i></span>
        <span>-{{Employment.city}}</span>
        
      </div>
      
      
      <div class="">
        <span class="P1">{{Employment.salary}}</span>
        
        <span>招人数：{{Employment.num}}</span>
      </div> 

      <div class="P2">
        <span style="float:right;">公司：{{Employment.businessId}}</span>      
      </div>

      <div>
        <span>{{Employment.welfare}}</span>
        
      </div>
      </div>
      <div class="bottom">
        <span style="font-weight: bold;">职位描述：</span><br>
        {{Employment.description}}
      </div>
    </el-dialog>

<!-- 底部 -->
    <div class="footerDiv">
<!-- 分页 -->
    <div class="pageDiv">
    <el-pagination
     :page-size="pageSize"
      @current-change="currentChange" 
     :current-page.sync="currentPage"

      background
      layout="prev, pager, next" 
      :total="EmploymentData.length">
    </el-pagination>
    </div>
  
<!-- 批量删除 -->
      <div class="btnDiv">
        <el-button @click="toBatchDelete" size="mini" type="danger" plain>批量删除</el-button>
      </div>
    </div>
  </div>
  
</template>

<script>
import { findAllEmployment } from "@/api/employment.js";
import { deleteEmploymentById } from "@/api/employment.js"
import { saveOrUpdateEmployment} from "@/api/employment.js"
import { findAllBusiness  } from "@/api/business.js"
import { findAlljob } from "@/api/job.js"
import config from "@/utils/config.js";
import qs from "_qs@6.9.1@qs";
export default {
  
  
  data() {
    return {
      seeVisible: false,
      //动态标题
      dialogTitle:"修改招聘",
      job:'',
      pageSize: config.pageSize,
      input3:'',
      select:[],
      //模态框 显示与隐藏
      dialogFormVisible:false,
      formLabelWidth:"80px",
      currentPage:1,
      EmploymentData:[],
      Employment:{
       
      },
      //工种信息
      jobData:[],
      //商家信息
      BusinessData:[],
      //批量删除ids
      ids: [],
       //校验规则
       //存储商家姓名 联系电话的信息
      findNPbybusData:[],
      rules: {
        title: [{ required: true, message: "请输入兼职名称", trigger: "blur" }],
        job: [
          { required: true, message: "请选择工种", trigger: "blur" }
        ],
        num: [{ required: true, message: "请输入招聘人数", trigger: "blur" }],
        businessId: [
          { required: true, message: "请选择招聘公司", trigger: "blur" }
        ],
        salary: [
          { required: true, message: "请输入薪资水平", trigger: "blur" }
        ],
        welfare: [
          { required: true, message: "请输入福利", trigger: "blur" }
        ],
        status: [
          { required: true, message: "请输入发布状态", trigger: "blur" }
        ],
        workingHours: [
          { required: true, message: "请输入工作时间", trigger: "blur" }
        ],
        contactName: [
          { required: true, message: "请输入姓名", trigger: "blur" }
        ],
        contactPhone: [
          { required: true, message: "请输入联系电话", trigger: "blur" }
        ],
        description: [
          { required: true, message: "请输入联系电话", trigger: "blur" }
        ],
        province: [
          { required: true, message: "请选择省份", trigger: "change" }
        ],
        city: [{ required: true, message: "请选择城市", trigger: "change" }]
      }
      
    };
  },
  watch:{
    input3(){
      console.log(this.input3)  
      }
  },
  computed: {
    
    EmploymentList(){
      //2
      let temp = [...this.fenlei2()]
      // console.log(temp)
      
      let page = this.currentPage;
      let pageSize = config.pageSize;
      return temp.slice((page - 1) * pageSize, page * pageSize);
      /*temp.slice(0,pageSize);
      temp.slice(10,pageSize*2);
      temp.slice(20,pageSize*3);*/
      //截取数据
      //[1, 3 , 6,9,3,6,7]
     //arr.slice(2,5);//开始位置 ，结束位置，不包括结束位置的元素 【6，9，3】
    },
    //获取招聘信息
  },
  methods: {
    //模态框省份发生改变
    async dialogBusChange(val) {
      
      let temp = this.BusinessData;
      let result = temp.filter((item1)=>{
          return item1.id===val;
        })
      console.log(result);
      this.findNPbybusData=result;
      console.log(this.findNPbybusData);
      
      
    },
    //根据商家id导入姓名 电话 地址信息
   
    //右上角，模态框关闭之前
    beforeClose() {
      this.$refs["ruleForm"].resetFields();
      this.dialogFormVisible = false;
    },
    toCancel(formName) {
      //重置表单验证，关闭模态框
      this.$refs[formName].resetFields();
      this.dialogFormVisible = false;
    },
    currentChange(page) {
      this.currentPage = page;
    },
    //点击查找
    tosaV(){
      return 
    },
     //c查找
      fenlei2 () {
        const search =this.input3;
        if (search) {
           // filter() 方法创建一个新的数组，新数组中的元素是通过检查指定数组中符合条件的所有元素。
           // 注意： filter() 不会对空数组进行检测。
           // 注意： filter() 不会改变原始数组。
           return this.EmploymentData.filter(data => {
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
         return this.EmploymentData;
       },
    //保存
    
    async toSave(formName){ 
        
      
        try{
          let Employment1=this.Employment;
          
          delete Employment1.startTime;
          delete Employment1.endTime;
          delete Employment1.publishTime;
          this.dialogFormVisible = false;
          console.log(Employment1)
          let res = await saveOrUpdateEmployment(Employment1);
          this.init();
          
      }catch(err){
        console.log(err);
       }
      },
    //增加
    toAdd() {
          this.dialogTitle = "发布招聘";
          this.Employment = {};
          this.dialogFormVisible = true;
          this.getBusinessData();
          this.getjobData();
          
        
    },
    //查看
    toSee(row) {
      this.Employment = { ...row };

      console.log(this.Employment.businessId);
      let temp = this.BusinessData;
      console.log(temp);
     
      // console.log(temp.id);
      // let result = temp.filter((item1)=>{
      //     return item1.id=this.Employment.businessId;
      //   })
      // console.log(this.result);
      // this.Employment.businessId=result.name;
      // console.log(this.Employment.businessId);
      this.seeVisible = true;
    },
    //编辑
    toEdit(row) {
      this.dialogTitle = "修改招聘";
      this.dialogFormVisible = true;
      this.Employment = {...row};
      this.getBusinessData();
      this.getjobData();
      // console.log(this.Employment);
      
    },
    //删除
    async toDelete(id) {
      
     
      try {
        let res = await deleteEmploymentById(id);
        this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success'
            });
            this.init();
      } catch (err) {
        console.log(err);
       
      }
    },
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
                  let res = await deleteEmploymentById({ id: id });
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
                this.init();
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
      //console.log(val);
      let ids = val.map(item => {
        return item.id;
      });
      this.ids = ids;
    },
  
  
  //当工作类型发生改变
  async jobChange(val) {
      
      //val 是option的value值
      if (val) {
        try {
          let res = await findBusinessByJob({ job: val });
          this.EmploymentData = res.data;
          this.currentPage = 1;
        } catch (error) {
          config.errorMsg(this, "通过job查找招聘信息错误");
        }
      } else {
        this.init();
      }
    },
  async  init () {
      
      try {
        // let res = await this.$store.dispatch("FindAllCity");
        
        let res = await findAllEmployment();
        let temp = res.data;
        // temp.forEach(item =>{
        //   let temp1 = item.status;
        //     if(temp1 == "完结"){
        //         this.EmploymentData = temp;
             
        //     }
        
        // });
        
        
        let result = temp.filter((item1)=>{
          return item1.status=="招聘中"
        })
         this.EmploymentData=result;
          console.log(this.EmploymentData);
      }
      
      catch(err){
        console.log(err);
        }

      },

  //获取商家信息
  async getBusinessData(){
        try{
          let res = await findAllBusiness();
          
          this.BusinessData = res.data;
        }catch (err){
          console.log(err);
        }
        
      },
  async getjobData(){
        try{
          let res = await findAlljob();
          
          this.jobData = res.data;
        }catch (err){
          console.log(err);
        }
        
      },    
    
  },
  
  created() {
    this.init();
    
  },
  mounted() {
    
  }
};
</script>
<style lang="scss" scoped>
.footerDiv {
  overflow: hidden;
  margin-top: 10px;
  .btnDiv {
    float: left;
  }
  .pageDiv {
    float: right;
  }
}
.a{
  position: absolute;
  left: 85%;
  bottom: 95%;
}
.b{
  text-align: right;

  }
.searchDiv{
    height: 80px;
}
.dialog-footer {
  text-align: center;
  margin-top: -30px;
}
.P1{
  font-size: 30px;
  color: orangered;
  float:right;
}
.P2{
  position: absolute;
  left: 87%;
  bottom: 60%
}
.bottom {
  height: 200px;
  border-top:1px solid #ccc;
}
.top{
  height: 100px;
}
</style>
