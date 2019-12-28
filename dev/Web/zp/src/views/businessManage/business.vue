/*
 * @Author: liuyr
 * 商家列表页面
 * @Date: 2019-12-23 17:11:53
 * @Last Modified by: liuyr
 * @Last Modified time: 2019-12-23 21:07:21
 */

<template>
  <div id="businessList">
    <div class="searthDiv">
<!--      省份-->
      <el-select v-model="province" clearable placeholder="省份"   @change="proChange(province)">
        <el-option
          v-for="item in provinceOptions"
          :key="item.id"
          :label="item.name"
          :value="item.name">
        </el-option>
      </el-select>
<!--      城市-->
      <el-select v-model="city" clearable placeholder="城市">
        <el-option
          v-for="item in cityOptions"
          :key="item.id"
          :label="item.name"
          :value="item.name">
        </el-option>
      </el-select>
<!--      行业-->
      <el-select v-model="industry" clearable placeholder="行业">
        <el-option
          v-for="item in industryOptions"
          :key="item"
          :label="item"
          :value="item">
        </el-option>
      </el-select>
<!--规模-->
      <el-select v-model="scale" clearable placeholder="规模" @change="scaleChange(scale)">
        <el-option
          v-for="item in scaleOptions"
          :key="item"
          :label="item"
          :value="item">
        </el-option>
      </el-select>

    </div>
    <div class="tableDiv">
      <el-table
        ref="multipleTable"
        :data="businessList"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="selectionChange">
        <el-table-column align="center" type="selection" width="55"></el-table-column>
        <el-table-column align="center" prop="name" label="企业名称"></el-table-column>
        <el-table-column align="center" prop="contactName" label="联系人"></el-table-column>
        <el-table-column align="center" prop="industry" label="行业"></el-table-column>
        <el-table-column align="center" label="所在地">
          <template slot-scope="scope">{{scope.row.province}}-{{scope.row.city}}</template>
        </el-table-column>
        <el-table-column align="center" prop="scale" label="公司规模"></el-table-column>
        <el-table-column align="center" label="详情">
          <template slot-scope="scope">
            <el-button @click="toSee(scope.row)" type="text" size="small">查看</el-button>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作" width="100">
          <template slot-scope="scope">
            <el-button type="text" @click="toEdit(scope.row)" size="small">编辑</el-button>
            <el-button type="text" size="small" @click="toDelete(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div id='paging'>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="pageSize"
          background
          layout="total, sizes, prev, pager, next, jumper"
          :total="BusinessData.length">
        </el-pagination>
      </div>
      <div>
        <button @click="toBacthDel">111</button>
      </div>
    </div>
    <div>
      <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="631"
        height="631">
       <div>
         <span>行业类型</span>{{motaikuang.industry}}
       </div>
        <div>
          <span>成立时间</span>{{motaikuang.establishedTime}}
        </div>
        <div>
          <span>注册资本</span>{{motaikuang.registeredCapital}}
        </div>
        <div>
          <span>公司规模</span>{{motaikuang.scale}}
        </div>
        <div>
          {{motaikuang.description}}
        </div>
        <div>
          <a :href="motaikuang.businessLicense" target="_blank">
            <img :src="motaikuang.businessLicense">
          </a>
        </div>
        <span slot="footer" class="dialog-footer">
       <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
       </span>
      </el-dialog>
    </div>

    <div>
      <!-- Form -->
      <el-dialog title="收货地址" :visible.sync="dialogFormVisible" width="50%">
        <el-form :model="form">
          {{currentBus}}
<!--          第一行-->
          <el-row :gutter="30">
            <el-col :span="12"><div class="grid-content bg-purple">
              <el-form-item label="公司名称" :label-width="formLabelWidth">
                <el-input v-model="currentBus.name" autocomplete="off"></el-input>
              </el-form-item>
            </div></el-col>
            <el-col :span="12"><div class="grid-content bg-purple-light">
              <el-form-item label="所属行业" :label-width="formLabelWidth">
                <el-input v-model="currentBus.industry" autocomplete="off"></el-input>
              </el-form-item>
            </div></el-col>
<!--            第二行-->
          </el-row>
          <el-row :gutter="30">
            <el-col :span="12"><div class="grid-content bg-purple">
              <el-form-item label="公司规模" :label-width="formLabelWidth">
                <el-input v-model="currentBus.scale" autocomplete="off"></el-input>
              </el-form-item>
            </div></el-col>
            <el-col :span="12"><div class="grid-content bg-purple-light">
              <el-form-item label="所在城市" :label-width="formLabelWidth">
                <el-row>
                  <el-col :span="12"><div class="grid-content bg-purple">
                    <el-select v-model="currentBus.province" placeholder="请选择省份" @change="diaolongProChange">
                      <el-option
                        v-for="item in provinceOptions"
                        :key="item.id"
                        :label="item.name"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </div></el-col>
                  <el-col :span="12"><div class="grid-content bg-purple-light">
                    <el-select v-model="currentBus.city" placeholder="请选择城市">
                      <el-option
                        v-for="item in provinceCityData"
                        :key="item.id"
                        :label="item.name"
                        :value="item.name">
                      </el-option>
                    </el-select>
                  </div></el-col>
                </el-row>

              </el-form-item>
            </div></el-col>
          </el-row>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
      </el-dialog>

    </div>
  </div>
</template>

<script>
  import {findAllProvince} from "@/api/province.js"
  import {findAllCity,CityfindByProvinceId} from "../../api/city";
  import {findAllBusiness} from "../../api/check";
  import {BusinessfindByProvince,BusinessfindByCity,BusinessfindByIndustry,BusinessfindByScale,BusinessdeleteById} from "../../api/business";
  import config from "../../utils/config";
  // import config from "@/utils"
export default {
  data() {
    return {

      currentPage:1 ,
      pageSize:10,
      dialogVisible:false,
      value:'',
      province:'',
      city:'',
      industry:'',
      scale:'',
      // 省份
      provinceOptions:null,
      // 规模
      scaleOptions:null,
      // 行业
      industryOptions:null,
      // 城市
      cityOptions:null,
      // 商家
      BusinessData:[],

      multipleSelection: [],

      motaikuang:[],
      currentBus:[],
      dialogFormVisible: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '70px',
     //省份对应的城市信息
      provinceCityData:[],
    };
  },
  computed: {
    businessList(val) {
      //  1   2   3
      let temp = [...this.BusinessData];
      let pageSize = this.pageSize;
      let page = this.currentPage;
      return temp.slice((page - 1) * pageSize, page * pageSize);
    },
  },
  methods: {
    //模态框省份发生改变
    async diaolongProChange(val) {
      if (+this.currentBus.province) {
        this.currentBus.city='';
      }
      try {
        let res = await CityfindByProvinceId({provinceId:val});
        this.provinceCityData=res.data
      } catch (e) {
        config.errorMsg(this, "查找失败")
      }
    },
    toBacthDel(){

      let ids=this.multipleSelection;
      if (ids.length>0){
          this.$alert('是否删除', '提示', {
          confirmButtonText: '确定',
          callback: action => {
            let re=[];
            if(action=== 'confirm'){
              ids.forEach(async (id) => {
                try {
                  let res = await BusinessdeleteById({id: id});
                  re.push(res.status)
                }catch (e) {
                  re.push(500);
                  // config.errorMsg(this,"失败")
                }
              });
              setTimeout(()=>{
                let resu =re.every((item)=>{
                  return item===200;
                });
                if (resu){
                  alert("成功");
                }else {
                  alert('失败')
                }
                this.findAllBusiness()
              },2000)
            }
          }
        });

      }else {
        this.$message({
          message: '警告哦，这是一条警告消息',
          type: 'warning'
        });

      }


    },

    async proChange(val) {
      console.log(val);
      if(val){
        try{
          let res = await BusinessfindByProvince({province: val});
          this.BusinessData =res.data;
        }catch (e) {
          config.errorMsg(this,'通过省份信息查找错误')
        }
      }else {
        this.findAllBusiness();
      }

    },

    async scaleChange(val) {
      console.log(val);
      if(val){
        try{
          console.log(val);
          let res = await BusinessfindByScale({province: val});
          console.log(res);
          this.BusinessData =res.data;
        }catch (e) {
          config.errorMsg(this,'通过省份信息查找错误')
        }
      }else {
        this.findAllBusiness();
      }

    },

    handleSizeChange(val) {
      this.pageSize=val;

    },
    handleCurrentChange(val) {
      this.currentPage = val;
    },

    //查看
    toSee(row) {
      this.dialogVisible=true;
      this.motaikuang={...row};
    },
    //编辑
    toEdit(row) {
      this.currentBus= {...row};
      let res = this.provinceOptions.filter((item)=>{
         if(row.province==item.name){
           return item.id;
         }
      })[0];
      console.log(res);
      this.diaolongProChange(res.id);

      this.dialogFormVisible=true;
    },
    //删除
    toDelete(id) {

        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
          try {
            let res = await BusinessdeleteById({id:id});
            if (res.status===200){
              this.findAllBusiness()
            }
          } catch (e) {
            config.errorMsg(this,'删除失败');
          }
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });

    },
    //复选框选中切换
    selectionChange(val) {
      //val 就是选中的对象组成的数组
      let  ids = val.map(item=>{
        return item.id;
      });
      this.multipleSelection=ids;
      console.log(val);
    },
    // 查找省份信息
    async findAllpro() {
      try {
        let res = await findAllProvince();
        this.provinceOptions=res.data;
        // console.log(res.data)
      } catch (e) {
         // config.errorMsg(this,'查找错误')
      }
    },
// 查找城市信息
    async findAllcity() {
      try {
        let res = await findAllCity();
        this.cityOptions=res.data;
        // console.log(res.data);
      } catch (e) {
        // config.errorMsg(this,'查找错误')
      }
    },
// 查找商家信息
    async findAllBusiness() {
      try {
        let res = await findAllBusiness();
        this.BusinessData=res.data;
        // console.log(res.data);
        let scaleArr = res.data.map(item => {
          return item.scale;
        });
        //去重
        this.scaleOptions = [...new Set(scaleArr)];
        //规模数组
        let industryArr = res.data.map(item => {
          return item.industry;
        });
        //去重
        this.industryOptions = [...new Set(industryArr)];

      } catch (e) {
        // config.errorMsg(this,'查找错误')
      }
    }
  },
  created() {
    this.findAllpro();
    this.findAllcity();
    this.findAllBusiness();
  },
  mounted() {}
};
</script>
<style scoped>
  #paging{
    float: right;
  }
</style>
