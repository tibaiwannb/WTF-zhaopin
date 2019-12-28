
import axios from '@/utils/axios'
/* 查找数据 */
export async function findAllBusiness() {
  let res = await axios.get('/Business/findAll');
  return res;
}
