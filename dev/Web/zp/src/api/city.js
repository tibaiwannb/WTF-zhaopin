/*
 * @Author: liuyr 
 * 城市模块API
 * @Date: 2019-12-22 18:54:17 
 * @Last Modified by: liuyr
 * @Last Modified time: 2019-12-22 19:53:09
 */

import axios from '@/utils/axios'

/* 查找数据 */
export async function findAllCity() {
  let res = await axios.get('/City/findAll');
  return res;
}

/*
* 通过id删除城市信息
* */
export function CitydeleteById(param) {
  return axios.post('/City/deleteById',param)
}


/**
 *查找全部城市信息通过id
 */
export function CityfindById(parm) {
  return axios.get('/City/findById',{params: parm})
}
/**
 *查找全部城市信息通过省份id
 */
export function CityfindByProvinceId(parm) {
  return axios.get('/City/findByProvinceId',{params: parm})
}

/**
 *保存或更新城市信息
 * POST /City/saveOrUpdate
 */
export function saveOrUpdate(parm) {
  return axios.post('/City/saveOrUpdate',parm)
}
