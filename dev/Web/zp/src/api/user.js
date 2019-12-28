/**
 * 查找所有信息模块
 */
import axios from '@/utils/axios'

export function findAllJobhunter() {
  return axios.get('/Jobhunter/findAll',);
 
}
/**f
 * 删除
 * @param {*} param 
 */
export function JobhunterdeleteById(param) {
  return axios.post('/Jobhunter/deleteById', param);
}


/**
 * 通过性别查找信息
 * @param {Object} param {id:''}
 */
export function findJobhunterByGender(param) {
  return axios.get('/Jobhunter/findByGender', { 
    params: param
  });
}

/**
 * 通过学历选取信息
 * @param {Object} param {id:''}
 */
export function findJobhunterByEducation(param) {
  return axios.get('/Jobhunter/findByEducation', { 
    params: param
  });
}

/**
 * 修改信息
 * @param {*} param 
 */
export function saveOrUpdate(param) {
  return axios.post('/Jobhunter/saveOrUpdate', param);
}