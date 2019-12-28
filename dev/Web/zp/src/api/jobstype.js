/*
 * @Author: lixf 
 * @Date: 2019-12-27 18:30:42 
 * @Last Modified by: lixf
 * @Last Modified time: 2019-12-27 18:33:50
 */
import axios from '@/utils/axios'
/**
 * 通过id删除职位类型信息
 * @param {object} param {id:''}
 */
export function deleteJobTypeById(param){
  return axios.post('/JobType/deleteById',param);
}

/* 查找数据 */
export  function findAllJobType() {
  return axios.get('/JobType/findAll');
}

/**
 * 通过id查找职位类型信息
 * @param {object} param {id:''}
 */
export  function findJobTypeById(param) {
  return axios.get('/JobType/findById',{params:param});
}


/**
 * 保存或更新职位类型信息
 * @param {object} param 
 */
export function saveOrUpdateJobType(param){
  return axios.post('/JobType/saveOrUpdate',param);
}