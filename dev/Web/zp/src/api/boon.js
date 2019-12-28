/*
 * @Author: lixf 
 * @Date: 2019-12-25 11:18:21 
 * @Last Modified by: lixf
 * @Last Modified time: 2019-12-25 11:20:56
 */

import axios from '@/utils/axios'
/**
 * 通过id删除福利信息
 * @param {object} param {id:''}
 */
export function deleteWelfareById(param){
  return axios.post('/Welfare/deleteById',param);
}

/* 查找数据 */
export  function findAllWelfare() {
  return axios.get('/Welfare/findAll');
}

/**
 * 通过id查找福利信息
 * @param {object} param {id:''}
 */
export  function findWelfareById(param) {
  return axios.get('/Welfare/findById',{params:param});
}


/**
 * 保存或更新福利信息
 * @param {object} param 
 */
export function saveOrUpdateWelfare(param){
  return axios.post('/Welfare/saveOrUpdate',param);
}