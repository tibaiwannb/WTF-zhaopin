/*
 * @Author: liuyr 
 * 商家审核页面
 * @Date: 2019-12-23 17:11:53 
 * @Last Modified by: liuyr
 * @Last Modified time: 2019-12-23 21:38:08
 */
<template>
  <div id="businessCheck">
<!--    下拉框-->
    <div id="content">
      <div id="choice-type">
<!--        v-model 绑定值-->
<!--        clearable 是否可以清空选项默认false 即不写clearable就不能清空-->
<!--        placeholder value=''时的下拉框的 即下拉框没下拉选择时下拉框显示的内容-->
        <el-select v-model="value" clearable placeholder="全部" >
<!--         el-option 下拉框选项内容for循环遍历options内容出来-->
<!--          :label   显示值  :xxx="xx"传入的是变量xx  xxx="xx"传入的是值xx-->
<!--          :value    传后台的值-->
          <el-option
            v-for="item in options"
            :key="item"
            :label="item"
            :value="item">
          </el-option>
        </el-select>
      </div>
    </div>
<!--    表格-->
    <div id="business-exa-table">
      <div id="mytable">
<!--        ref  类似于起一个id 于JavaScript document.getElementById("#id") 可以通过$refs.multipleTable.xxx改变其内容-->
<!--        data  显示的数据   businessList返回的是一个符合pageSize大小的数组-->
<!--        @selection-change  当选择项发生变化时会触发该事件-->
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
<!--        企业名称-->
<!--       label 实现的标题-->
<!--        prop 对应列内容的字段名，也可以使用 property 属性 prop="xxx" xxx为传入数组对象所对应的键值即key:value 的 key-->
        <el-table-column
          prop="name"
          label="企业名称"
          width="200">
        </el-table-column>
<!--        联系人-->
        <el-table-column
          prop="contactName"
          label="联系人"
          width="120">
        </el-table-column>
<!--        联系方式-->
        <el-table-column
          prop="contactPhone"
          label="联系方式"
          width="220">
        </el-table-column>
<!--        行业-->
        <el-table-column
          prop="industry"
          label="行业"
          width="120">
        </el-table-column>
<!--        所在地-->
<!--          通过 Scoped slot 可以获取到 row, column, $index 和 store（table 内部的状态管理）的数据-->
<!--          scope.row 获取到的是该行的内容-->
        <el-table-column
          label="所在地"
          width="150">
          <template slot-scope="scope">{{scope.row.province}}-{{scope.row.city}}</template>
        </el-table-column>
<!--        公司规模-->
          <el-table-column
            prop="scale"
            label="公司规模"
            width="160">
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
<!--                当该行的status为待审核时显示按键，下面的同理-->
                <div v-if="(scope.row.status==='待审核')">
                <el-button  type="text" size="small" style="background-color: green;" class="button" @click="sucessCheck(scope.row)">通过</el-button>
                <el-button type="text" size="small" style="background-color: red;" class="button" @click="test(scope.row)">拒绝</el-button>
                </div>
                <span v-else-if="scope.row.status==='审核通过'" style="color: green">已通过</span>
                <span v-else style="color: red">已拒绝</span>
                <!--拒绝理由的框-->
                <div>
                <el-dialog title='请填写拒绝理由' :visible.sync="dialogFormVisible">
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
      <div id='paging'>
<!--        current-page   当前页数-->
<!--        page-size      每页大小-->
<!--        size-change   pageSize改变时会触发-->
<!--        current-change  currentPage 改变时会触发-->
<!--        total  数据的数量  这里是显示数据筛选后的条数 fenye返回的是一个经过筛选后的数组-->
<!--        background 分页按键背景颜色-->
<!--        layout  布局格式详情见官方文档-->
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
<!--    visible.sync 显示状态true or false-->
    <el-dialog :title="currentBus.name" :visible.sync="seeVisible">
      <div class="seeDiv">
        <span>行业类型：</span>
        {{currentBus.industry}}
      </div>
      <div class="seeDiv">
        <span>成立时间：</span>
        {{currentBus.establishedTime}}
      </div>
      <div class="seeDiv">
        <span>注册资本：</span>
        {{currentBus.registeredCapital}}
      </div>
      <div class="seeDiv">
        <span>公司规模：</span>
        {{currentBus.scale}}
      </div>
      <div class="descDiv">&nbsp;&nbsp;&nbsp;&nbsp;{{currentBus.description}}</div>
      <div class="imgDiv">
        <a :href="currentBus.businessLicense" target="_blank">
          <img :src="currentBus.businessLicense" alt width="200" height="150" />
        </a>
      </div>
    </el-dialog>

  </div>
</template>

<script>

  //导入函数
  import {findAllBusiness} from "../../api/business";
  import config from '../../utils/config'
  import {saveOrUpdate} from "../../api/business";

  export default {
  data() {
    return {
       //拒绝理由是否隐藏
      dialogFormVisible:false,
      // 拒绝理由
      textRefuse:'',
      //下拉框选项数据
      options: '',
     //下拉框和搜索使用的变量
     value:'',
      //表格数据
      tableData: [],
      //多选框的数据框
      multipleSelection: [],
      //没用到
      allEletion:[],
      //分页数据  当前页1 大小10条
      currentPage:1 ,
      pageSize:10,
      //查看框隐藏与否
      seeVisible:false,
      //记载着要的拒绝数据
      test1:{},
      //查看对象
      currentBus:{}
    };
  },
    //计数函数
  computed: {
    //分页

    //返回分页数组函数
    businessList() {
      //fenlei2为一个搜索函数  返回一个搜索后的数组
      let temp = [...this.fenlei2()];
    //   if (temp.length==this.tableData.length){
    //     // return temp;
    //     let pageSize = this.pageSize;
    //     let page = this.currentPage;
    //     return temp.slice((page - 1) * pageSize, page * pageSize)
    //   }else {
    //     let pageSize = this.pageSize;
    //     let page = this.currentPage;
    //     return temp.slice((page - 1) * pageSize, page * pageSize);
    // }
      let pageSize = this.pageSize;
      let page = this.currentPage;
      return temp.slice((page - 1) * pageSize, page * pageSize);
    },

    //功能是为了实现下方total数量随着页面数组实时变化
    fenye(){
      let temp = [...this.fenlei2()];
      return temp
    },
  },
    //方法函数
  methods: {
    toSee(row){
      this.currentBus = { ...row };
      this.seeVisible = true;
    },

    //点击表单拒绝按键时的返回当前行的值给test1
     test(row) {
       this.dialogFormVisible=true;
       this.test1=row
    },
    //分类函数(失败) 步骤繁琐
    // fenlei(){
    //    let temp=[];
    //    console.log(this.value);
    //    for (let i=0;i<this.tableData.length;i++)
    //    {
    //      if(this.value==this.tableData[i].status){
    //        temp.push(this.tableData[i]);
    //      }
    //    }
    //    this.tableData=temp;
    // },
         //分类2
        // 模糊搜索
        fenlei2 () {
          const search = this.value;
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
      if (row.status=='待审核') {
        row.status = '审核通过';
      }
      // row.status = '待审核';
      try {
        let res = await saveOrUpdate(row);
        this.findAllBus();
      }catch (e) {
      }
    },
//拒绝函数
    async disCheck(row) {
      row.status = '拒绝';
      this.dialogFormVisible=false;
      try {
        let res = await saveOrUpdate(row);
        this.findAllBusiness();
      }catch (e) {
      }
    },
    //数据导入
    async findAllBus() {
      try {
        let res = await findAllBusiness();
        this.tableData=res.data;
        let statusArr = res.data.map(item=>{
          return item.status;
        });
        // 数组去重 原理 变成集合 集合不允许出现相同值
        this.options=[...new Set(statusArr)];
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
    //帮当前选择的值赋予multipleSelection
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    //没用到
    allEte(){
      let temp=[];
      for (var i=0;i<this.tableData.length;i++){
        temp.push(this.tableData[i]);
      }
      this.allEletion=temp;
    },

    //分页
    handleSizeChange(val) {
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
    this.findAllBus();
  },
  mounted() {

  }
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
  #business-exa-table{
    margin-top: 20px;
  }
  .button{
    color: white;
    padding-left: 4px;
    padding-right: 4px;
  }
  .seeDiv {
    border-bottom: 1px solid #ccc;
    line-height: 30px;
    font-weight: bold;
  }
  .seeDiv  span {
    color: #777;
  }
  .descDiv {
    font-weight: bold;
    color: #777;
    font-size: 12px;
    line-height: 30px;
    padding: 10px 0;
    border-bottom: 1px solid #ccc;
  }
  .imgDiv {
    text-align: center;
  }
  .imgDiv a{
    display: block;
  }
</style>
