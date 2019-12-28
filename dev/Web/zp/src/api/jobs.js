/*
 * @Author: lixf 
 * @Date: 2019-12-27 16:56:17 
 * @Last Modified by: lixf
 * @Last Modified time: 2019-12-27 17:13:08
 */
import axios from '@/utils/axios'
/**
 * 通过id删除职位信息
 * @param {object} param {id:''}
 */
export function deleteJobsById(param){
  return axios.post('/Jobs/deleteById',param);
}

/* 查找数据 */
export  function findAllJobs() {
  return axios.get('/Jobs/findAll');
}

/**
 * 通过id查找职位信息
 * @param {object} param {id:''}
 */
export  function findJobsById(param) {
  return axios.get('/Jobs/findById',{params:param});
}

/**
 * 通过状态查找职位信息
 * @param {object} param {provinceId:''}
 */
export  function findJobsByStatus(param) {
  return axios.get('/Jobs/findByStatus',{params:param});
}

/**
 * 保存或更新职位信息
 * @param {object} param 
 */
export function saveOrUpdateJobs(param){
  return axios.post('/Jobs/saveOrUpdate',param);
}