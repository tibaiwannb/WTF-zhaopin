/*
 * @Author: liuyr 
 * 职位管理页面
 * @Date: 2019-12-23 17:11:53 
 * @Last Modified by: lixf
 * @Last Modified time: 2019-12-28 15:05:51
 */
<template>
  <div id="modulePosition">职位管理页面
    <div>
    {{jobData}}

    <el-button @click="toAdd" size="small" type="primary">新增职位</el-button>
    <el-button @click="toAdd1" size="small" type="primary">新增职位类型</el-button>

    <el-table :data="jobData">
        
        <el-table-column  type="expand" prop="job">
          <template slot-scope="scope" >
            <el-table  :data="scope.row.job" >
                <el-table-column prop="name" label="职位"  align="left">
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

        <el-table-column prop="name" label="类型"  align="left" >
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

        <!--模态框 -->
        <el-dialog :title="diologTitle" :visible.sync="dialogFormVisible"> 
          <el-form :model="job">
            <el-form-item label="职位" :label-width="formLabelWidth"> 
              <el-input v-model="job.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="职位类型" :label-width="formLabelWidth">
                <el-select v-model="job.jobTypeId" placeholder="请选择职位类型">
                  <el-option label="请选择" value></el-option>
                  <el-option 
                  v-for="(item,index) in jobData" 
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
        <el-form :model="job">
          <el-form-item label="新增职位类型名称" :label-width="formLabelWidth"> 
            <el-input v-model="job.name" autocomplete="off"></el-input>
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
import { deleteJobsById,findAllJobs,findJobsById,findJobsByStatus,saveOrUpdateJobs } from "@/api/jobs.js";
import { deleteJobTypeById,findAllJobType,findJobTypeById,saveOrUpdateJobType } from "@/api/jobstype.js";
import config from "@/utils/config.js";
export default {
  data() {
    return {
      jobData:[],

      job:{
        name:'',
        jobTypeId:''
      },
      
      //模态框显示与隐藏（false隐藏）
      dialogFormVisible:false,
      dialogFormVisible1:false,
      diologTitle:"新增职位",
      diologTitle1:"新增职位类型",
      //表单左侧的文字宽度
      formLabelWidth:"130px",
    };
  },
  computed: {},
  methods: {
    //查找所有职位类型，获取职位名字,将名字赋值给要传回后台的状态，通过状态找到职位类型所含的职位
    // async findAllJT(page){
    //   try{
    //     let res = await findAllJobType();
    //     let temp = [...res.data];
    //     temp.forEach(async (item)=>{
    //       let status = item.name;
    //       let resp = await findJobsByStatus({staus:status})
    //       console.log(resp);
    //       item.job = resp.data;
    //     })
    //     setTimeout(()=>{
    //       this.jobData = temp;
    //     },2000)
    //   }catch(err){
    //     this.$notify.error({
    //       title: "错误",
    //       message: "查找失败"
    //     });
    //   }
    // },

    //查找所有职位类型，获取职位id,通过职位id找到职位类型所含的职位
    async findAllJT(page){
      try {
        // let res = await this.$store.dispatch("FindAllCity");
        //获取职业
        let res = await findAllJobs();
        let temp = [...res.data];
        // console.log(temp)
        //获取行业
        let resp = await findAllJobType()
        let temps = [...resp.data]
        // console.log(temps)
         
        temps.forEach(item =>{
          
          let id = item.id
          // console.log(item.id,'------')
          let job = temp.filter((ite)=>{
            return ite.jobTypeId === id;
          });
          item.job = job; 
        })
        setTimeout((items)=>{
          this.jobData = temps
          },500)
        }catch (err) {
        this.$notify.error({
          title: "错误",
          message: "查找失败"
        });
      }
    },

    //新增按钮
    toAdd(){
      this.diologTitle="新增职位";
      this.job = {};
      this.dialogFormVisible = true  
      this.findAllJT();       
    },

    //编辑按钮
    toEdit(row){
      this.diologTitle="编辑城市信息";
      this.job = {...row};
      console.log(this.job);
      this.dialogFormVisible = true
      this.findAllJT();  
    },

    //保存
    async toSave(){
      try {
        let res = await saveOrUpdateJobs(this.job); 
        console.log(this.job);
        this.dialogFormVisible = false; 
        this.findAllJT();
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
    async toDelete(id){
      try {
        let res = await deleteJobsById({ id: id }); 
        this.findAllJT();
        this.$notify({
            title: "成功",
            message: "保存成功",
            type: "success"
          });
      }catch(err){
        console.log(err);
      }
    },

    //新增按钮1
    toAdd1(){
      this.diologTitle1="新增职位类型";
      this.province = {};
      this.dialogFormVisible1 = true   ;
      this.findAllJT();       
    },

    //保存1
    async toSave1(){
      try {
        let res = await saveOrUpdateJobType(this.job); 
        this.dialogFormVisible1 = false; 
        this.findAllJT();
        this.$notify({
            title: "成功",
            message: "保存成功",
            type: "success"
          });
      }catch(err){
        console.log(err);
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
            let res = await deleteJobTypeById({ id: id });
            if (res.status === 200) {
              config.successMsg(this, "删除成功");
              this.findAllJT();
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
      this.diologTitle1="编辑职位类型信息";
      //{...row}   把row展开，然后放到一个新的数组中(复制，使row不是同一个地址)
      this.job = {...row};
      // delete this.province.name;
      console.log(this.job);
      this.dialogFormVisible1 = true
      this.findAllJT();  
    },

  },
  created() {
    this.findAllJT();
  },
  mounted() {}
};
</script>
<style scoped>
</style>
