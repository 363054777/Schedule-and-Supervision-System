import request from '@/utils/request'

// 查询日程结果列表
export function listResult(query) {
  return request({
    url: '/schedule/result/list',
    method: 'get',
    params: query
  })
}

// 查询日程结果详细
export function getResult(resultId) {
  return request({
    url: '/schedule/result/' + resultId,
    method: 'get'
  })
}

// 新增日程结果
export function addResult(data) {
  return request({
    url: '/schedule/result',
    method: 'post',
    data: data
  })
}

// 修改日程结果
export function updateResult(data) {
  return request({
    url: '/schedule/result',
    method: 'put',
    data: data
  })
}

// 删除日程结果
export function delResult(resultId) {
  return request({
    url: '/schedule/result/' + resultId,
    method: 'delete'
  })
}
