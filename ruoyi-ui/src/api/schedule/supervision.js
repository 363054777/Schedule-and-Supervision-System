import request from '@/utils/request'

// 查询日程查看列表
export function listSupervision(query) {
  return request({
    url: '/schedule/supervision/list',
    method: 'get',
    params: query
  })
}

// 查询日程查看详细
export function getSupervision(itemId) {
  return request({
    url: '/schedule/supervision/' + itemId,
    method: 'get'
  })
}

// 新增日程查看
export function addSupervision(data) {
  return request({
    url: '/schedule/supervision',
    method: 'post',
    data: data
  })
}

// 修改日程查看
export function updateSupervision(data) {
  return request({
    url: '/schedule/supervision',
    method: 'put',
    data: data
  })
}

// 删除日程查看
export function delSupervision(itemId) {
  return request({
    url: '/schedule/supervision/' + itemId,
    method: 'delete'
  })
}

//查询未完成日程
export function getItemInfor() {
  return request({
    url: '/schedule/item/getItemNames',
    methods: 'GET',
  })
}
