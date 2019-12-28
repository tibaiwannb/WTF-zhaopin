import axios from '@/utils/axios'

export function findAlljob() {
    return axios.get('/Jobs/findAll');
   
}