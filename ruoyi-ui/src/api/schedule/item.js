import request from '@/utils/request'

// 查询日程管理列表
export function listItem(query) {
  return request({
    url: '/schedule/item/list',
    method: 'get',
    params: query
  })
}

// 查询日程管理详细
export function getItem(itemId) {
  return request({
    url: '/schedule/item/' + itemId,
    method: 'get'
  })
}

// 新增日程管理
export function addItem(data) {
  return request({
    url: '/schedule/item',
    method: 'post',
    data: data
  })
}

// 修改日程管理
export function updateItem(data) {
  return request({
    url: '/schedule/item',
    method: 'put',
    data: data
  })
}

// 删除日程管理
export function delItem(itemId) {
  return request({
    url: '/schedule/item/' + itemId,
    method: 'delete'
  })
}
