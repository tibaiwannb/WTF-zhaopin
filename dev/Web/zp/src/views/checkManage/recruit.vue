/*
 * @Author: liuyr
 * 招聘审核页面
 * @Date: 2019-12-23 17:11:53
 * @Last Modified by: liuyr
 * @Last Modified time: 2019-12-23 21:38:39
 */
<template>
  <div id="businerecruitCheck">
<!--    左边下拉框-->
    <div>
      <div id="content">
        <div id="choice-type">
          <el-select v-model="jobtype"  clearable placeholder="职位类型" @change="hh" size="mini">
            <el-option
              v-for="item in options"
              :key="item"
              :label="item"
              :value="item">
            </el-option>
          </el-select>
        </div>
      </div>
  <!--    右边下拉框和选择-->
      <div id="right">
        <el-input placeholder="请输入内容" v-model="myinput" class="input-with-select" style="width: 500px" clearable size="mini">
<!--          <el-select v-model="keytype" slot="prepend" clearable placeholder="请选择" style="width: 120px" @change="hhhh">-->
<!--            <el-option label="餐厅名" value="游戏"></el-option>-->
<!--            <el-option label="订单号" value="2"></el-option>-->
<!--            <el-option label="用户电话" value="3"></el-option>-->
<!--          </el-select>-->
          <el-button slot="append" icon="el-icon-search" @click="hhh"></el-button>
        </el-input>
      </div>
    </div>
    <!--    表格-->
    <div id="business-exa-table" style="margin-left: 2%">
      <div id="mytable">
        <el-table
          ref="multipleTable"
          :data="businessList"
          tooltip-effect="dark"
          style="width: 100%"
          @selection-change="handleSelectionChange">
          <!--        多选-->
          <el-table-column
            type="selection"
            width="55">
          </el-table-column>
          <!--        招聘标题-->
          <el-table-column
            prop="title"
            label="招聘标题"
            width="200">
          </el-table-column>
          <!--        发布人-->
          <el-table-column
            prop="contactName"
            label="发布人"
            width="120">
          </el-table-column>
          <!--        联系方式-->
          <el-table-column
            prop="contactPhone"
            label="联系方式"
            width="220">
          </el-table-column>
          <!--        职位-->
          <el-table-column
            prop="job"
            label="职位"
            width="120">
          </el-table-column>
          <!--        发布时间-->
          <el-table-column
            prop="publishTime"
            label="发布时间"
            width="250">
          </el-table-column>
          <!--        详细-->
          <el-table-column
            label="详细"
            width="120">
            <template slot-scope="scope">
              <el-button type="text" size="small" @click="toSee(scope.row)">查看</el-button>
            </template>
          </el-table-column>
          <!--        操作-->
          <el-table-column
            label="操作"
            width="180">
            <template slot-scope="scope" >
              <div v-if="(scope.row.auditStatus==='待审核'||scope.row.auditStatus=='')">
                <el-button  type="text" size="small" style="background-color: green;" class="button" @click="sucessCheck(scope.row)">通过</el-button>
                <el-button type="text" size="small" style="background-color: red;" class="button" @click="test(scope.row)">拒绝</el-button>
              </div>
              <span v-else-if="scope.row.auditStatus==='审核通过'" style="color: green">已通过</span>
              <span v-else style="color: red">已拒绝</span>
              <!--拒绝理由的框-->
              <div>
                <el-dialog title='请填写拒绝理由' :visible.sync="dialogFormVisible">
<!--             autosize    输入框大小-->
                  <el-input
                    type="textarea"
                    :autosize="{ minRows: 10, maxRows: 10}"
                    placeholder="请输入内容"
                    v-model="textRefuse">
                  </el-input>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="disCheck(test1)">确 定</el-button>
                  </div>
                </el-dialog>
              </div>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div style="margin-top: 20px" id="election-key">
        <el-button @click="toggleSelection()">取消选择</el-button>
        <el-button @click="piliangtongguo">通过</el-button>

      </div>
<!--      分页-->
      <div id='paging'>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="pageSize"
          background
          layout="total, sizes, prev, pager, next, jumper"
          :total="fenye.length">
        </el-pagination>
      </div>
    </div>

    <!--     查看的框-->
    <el-dialog title="招聘信息" :visible.sync="seeVisible" >
      <div style="margin-bottom: 10px">
        <span style="font-size: 30px;color:cornflowerblue">{{EmploymentCurr.title}}</span>
      </div>
      <el-row>
        <el-col :span="12"><div class="grid-content bg-purple">
          <div class="seeDiv">
            <span>招<span style="color:coral;font-size: 24px ">{{EmploymentCurr.num}}</span>人</span>
        </div>
        </div></el-col>
        <el-col :span="12"><div class="grid-content bg-purple-light">
          <div class="seeDiv" style="float: right">
            <span style="color: coral;font-size: 30px"> {{EmploymentCurr.salary}}</span>&nbsp;<span style="color: coral;font-size: 10px">元/月</span>
          </div>
        </div></el-col>
      </el-row>
          <div class="seeDiv">
            <span>工作地点：</span>
            <span style="font-size: 18px;color: #0096FA">{{EmploymentCurr.province}}-{{EmploymentCurr.city}}</span>
          </div>

      <el-row>
        <el-col :span="12"><div class="grid-content bg-purple">
          <div class="seeDiv">
          <span style="background-color:gold;padding: 2px 7px 2px;">{{EmploymentCurr.welfare}}</span>
        </div></div></el-col>
        <el-col :span="12"><div class="grid-content bg-purple-light">
          <div class="seeDiv">
            <span>工作时长：</span>
            <span style="color: #f56c6c;font-size: 18px">{{EmploymentCurr.workingHours}}小时</span>
          </div>
        </div>
        </el-col>
      </el-row>
          <div class="seeDiv">
            <div>
              <span style="color:coral;font-size: 20px">详细描述：</span>
              <div>
                {{EmploymentCurr.description}}
              </div>
            </div>
          </div>
    </el-dialog>
  </div>
</template>

<script>
  import {findAllEmployment} from "../../api/employment";
  import config from '../../utils/config'
  import {saveOrUpdateEmployment} from "../../api/employment";

  export default {
    data() {
      return {
        //拒绝理由是否隐藏
        dialogFormVisible:false,
        // 拒绝理由
        textRefuse:'',
        //选项数据
        options: '',
        //搜索数据
        value:'',
        //职业类型
        jobtype:'',
        //输入数据
        myinput:'',
        //关键数据
        keytype:'',
        //表格数据
        tableData: [],
        multipleSelection: [],
        allEletion:[],
        //分页数据
        currentPage:1 ,
        pageSize:10,
        //查看
        seeVisible:false,
        //
        test1:{},

        EmploymentCurr:{},
      };
    },
    //监视myinput的值的函数 目的清空输入框时显示全部数据
    watch: {
      myinput() {
        if(this.myinput==''){
          this.value = this.myinput;
        }
      }
    },
    computed: {
      //分页
      businessList(val) {
        //  1   2   3
        let temp = [...this.fenlei2()];
        let pageSize = this.pageSize;
        let page = this.currentPage;
        return temp.slice((page - 1) * pageSize, page * pageSize);
      },
      fenye(){
        let temp = [...this.fenlei2()];
        return temp
      },
    },
    methods: {

      toSee(row){
        this.EmploymentCurr = { ...row };
        this.seeVisible = true;
      },

      test(row) {
        this.dialogFormVisible=true;
        this.test1=row
      },
      //把职业类型的值赋予value
      hh(){
        let temp=this.jobtype;
        this.value=temp;

      },
      //把myinput的值赋予value
      hhh(){
        let temp=this.myinput;
        this.value=temp;
      },
      //把关键词的值赋予value
      hhhh(){
        let temp=this.keytype;
        this.value=temp;
      },
      //分类2
      // 模糊搜索
      fenlei2 () {
        const search =this.value;
        if (search) {
          // filter() 方法创建一个新的数组，新数组中的元素是通过检查指定数组中符合条件的所有元素。
          // 注意： filter() 不会对空数组进行检测。
          // 注意： filter() 不会改变原始数组。
          return this.tableData.filter(data => {
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
        return this.tableData;
      },

// 批量通过
      piliangtongguo(){
        for (let i=0;i<this.multipleSelection.length;i++){
          this.sucessCheck(this.multipleSelection[i])
        }
      },
// 通过函数
      async sucessCheck(row) {
        if (row.auditStatus=='待审核'||row.auditStatus=='') {
          row.auditStatus = '审核通过';
        }
        // row.auditStatus = '待审核';
        try {
          delete row.publishTime;
          delete row.endTime;
          delete row.startTime;
          let res = await saveOrUpdateEmployment(row);
          this.findAllEmp();
        }catch (e) {
        }
      },
//拒绝函数
      async disCheck(row) {
        row.auditStatus = '拒绝';
        this.dialogFormVisible=false;
        try {
          delete row.publishTime;
          delete row.endTime;
          delete row.startTime;
          let res = await saveOrUpdateEmployment(row);
          this.findAllEmpiness();
        }catch (e) {
        }
      },
      //数据导入
      async findAllEmp() {
        try {
          let res = await findAllEmployment();
          this.tableData=res.data;
          let auditStatusArr = res.data.map(item=>{
            return item.job;
          });
          this.options=[...new Set(auditStatusArr)];
          // console.log(this.tableData);
          // console.log(this.options);
        }catch (e) {
          config.errorMsg(this,'查找错误')
        }

      },

      //表格函数

      toggleSelection(rows) {
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row);
          });
        } else {
          this.$refs.multipleTable.clearSelection();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      allEte(){
        let temp=[];
        for (var i=0;i<this.tableData.length;i++){
          temp.push(this.tableData[i]);
        }
        this.allEletion=temp;
      },

      //分页
      handleSizeChange(val) {
        console.log(val);
        this.pageSize=val;
      },
      handleCurrentChange(val) {
        this.currentPage = val;
      },
      //查看
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }

      //下方按钮

    },
    created() {
      this.allEte();
      this.findAllEmp();
    },
    mounted() {},
  };
</script>
<style scoped>
  #election-key{
    float: left;
  }
  #paging{
    float: right;

    padding-top: 25px;
  }
  #mytable{
    margin-top: 10px;
  }
  .button{
    color: white;
    padding-left: 4px;
    padding-right: 4px;
  }
  #content {
    float: left;
    margin-bottom: 20px;
  }
  #right{
    float: right;
  }
  .seeDiv {
    border-bottom: 1px solid #ccc;
    line-height: 30px;
    font-weight: bold;
  }
  .seeDiv  span {
    color: #777;
  }
</style>

