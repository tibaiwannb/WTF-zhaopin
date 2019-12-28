/**
 * @Description:
 * @author HAI
 * @date 2019/12/25
 */

import axios from '@/utils/axios'
/*
* 通过id删除招聘信息
* */
export function EmploymentdeleteById(param) {
  return axios.post('/Employment/deleteById',param)
}
/**
 *查找全部招聘信息
 */
export function findAllEmployment() {
  return axios.get('/Employment/findAll')
}
/**
 *查找全部招聘信息通过城市
 */
export function EmploymentfindByCity(parm) {
  return axios.get('/Employment/findByCity',{parms:parm})
}
/**
 *查找全部招聘信息通过id
 */
export function EmploymentfindById(parm) {
  return axios.get('/Employment/findById',{parms: parm})
}

/**
 *查找全部招聘信息通过职位
 */
export function EmploymentfindByJob(parm) {
  return axios.get('/Employment/findByJob',{parms:parm})
}

/**
 *查找全部招聘信息通过标题
 */
export function EmploymentfindByTitle(parm) {
  return axios.get('/Employment/findByTitle',{parms:parm})
}

/**
 *查找全部招聘信息通过福利
 */
export function EmploymentfindByWelfare(parm) {
  return axios.get('/Employment/findByWelfare',{parms:parm})
}


/**
 *保存或更新招聘信息
 * POST /Employment/saveOrUpdate
 */
export function saveOrUpdate(parm) {
  return axios.post('/Employment/saveOrUpdate',parm)
}
