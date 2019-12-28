/*
 * @Author: liuyr
 * 省份模块API
 * @Date: 2019-12-22 18:54:17
 * @Last Modified by: liuyr
 * @Last Modified time: 2019-12-22 19:53:09
 */

import axios from '@/utils/axios'

/* 查找数据 */
export async function findAllProvince() {
  let res = await axios.get('/Province/findAll');
  return res;
}

/*
* 通过id删除省份信息
* */
export function ProvincedeleteById(param) {
  return axios.post('/Province/deleteById',param)
}


/**
 *查找全部省份信息通过id
 */
export function ProvincefindById(parm) {
  return axios.get('/Province/findById',{params: parm})
}


/**
 *保存或更新省份信息
 * POST /Province/saveOrUpdate
 */
export function saveOrUpdate(parm) {
  return axios.post('/Province/saveOrUpdate',parm)
}
