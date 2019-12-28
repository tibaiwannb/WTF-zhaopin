/*
 * @Author: liuyr 
 * 城市管理页面
 * @Date: 2019-12-23 17:11:53 
 * @Last Modified by: liuyr
 * @Last Modified time: 2019-12-23 21:07:46
 */
<template>
  <div id="moduleCity">


    <div>
      <template>
        <el-table
          :data="tableData"
          style="width: 100%">
          <el-table-column
            prop="date"
            label="日期"
            width="180">
          </el-table-column>
        </el-table>
      </template>

    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData:[],
    };
  },
  computed: {},
  methods: {},
  created() {},
  mounted() {}
};
</script>
<style scoped>
</style>
