/**
 * @Description: 
 * @author HAI
 * @date 2019/12/25
*/

import axios from '@/utils/axios'
/*
* 通过id删除商家信息
* */
export function BusinessdeleteById(param) {
  return axios.post('/Business/deleteById',param)
}
/**
*查找全部商家信息
 */
export function findAllBusiness() {
    return axios.get('/Business/findAll')
}
/**
 *查找全部商家信息通过城市
 */
export function BusinessfindByCity(parm) {
  return axios.get('/Business/findByCity',{params:parm})
}
/**
 *查找全部商家信息通过id
 */
export function BusinessfindById(parm) {
  return axios.get('/Business/findById',{params: parm})
}

/**
 *查找全部商家信息通过行业
 */
export function BusinessfindByIndustry(parm) {
  return axios.get('/Business/findByIndustry',{params:parm})
}

/**
 *查找全部商家信息通过位置
 */
export function BusinessfindByLocation(parm) {
  return axios.get('/Business/findByLocation',{params:parm})
}

/**
 *查找全部商家信息通过省份
 */
export function BusinessfindByProvince(parm) {
  return axios.get('/Business/findByProvince',{params:parm})
}


/**
 *查找全部商家信息通过Scale
 */
export function BusinessfindByScale(parm) {
  return axios.get('/Business/findByScale',{params:parm})
}

/**
 *保存或更新商家信息
 * POST /Business/saveOrUpdate
 */
export function saveOrUpdate(parm) {
  return axios.post('/Business/saveOrUpdate',parm)
}
