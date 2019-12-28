/*
 * @Author: littorio 
 * @Date: 2019-12-25 09:38:17 
 * @Last Modified by: littorio
 * @Last Modified time: 2019-12-27 19:05:15
 */
import axios from '@/utils/axios'
//招聘
export function findAllEmployment() {
    return axios.get('/Employment/findAll');
   
}
/**
 * 通过id删除招聘信息
 * @param {Object} param {id:} 
 */
export function deleteEmploymentById(param) {
    return axios.post('/Employment/deleteById', param);

}

/**
 * 通过城市查找招聘信息
 * @param {Object} param {city:''}
 */
export function findEmploymentByCity(param) {
    return axios.get('/Employment/findByCity',param);

}
/**
 * 
 * @param {Object*} param {id:''} 
 */
export function findBusinessById(param) {
    return axios.get('/Employment/findById',{params:param});

}
/**
 * 通过工作查找招聘信息
 * @param {Object} param {job:''}
 */
export function findBusinessByJob(param) {
    return axios.get('/Employment/findByJob',{params:param});

}
/**
 * 通过标题查找招聘信息
 * @param {Object} param {title:''}
 */
export function findBusinessByTitle(param) {
    return axios.get('/Employment/findByTitle',{params:param});

}
/**
 * 通过标题查找招聘信息
 * @param {Object} param {welfare:''}
 */
export function findBusinessByWelfare(param) {
    return axios.get('/Employment/findByWelfare',{params:param});

}
/**
 * 通过Industry查找商家信息
 * @param {Object} param {scale:''}
 */
export function saveOrUpdateEmployment(param) {
    return axios.post('/Employment/saveOrUpdate',param);
}

/**
 * 查找所有求职信息（扩展）
 */
export function findAllWithJobhAndEmpl() {
  return axios.get('/EmploymentJobhunter/findAllWithJobhAndEmpl');
}

