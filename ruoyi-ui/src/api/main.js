import request from '@/utils/request'

// 查询不同日期的日程数
export function getItemByDate() {
  return request({
    url: '/index/getItemCount',
    method: 'get'
  })
}