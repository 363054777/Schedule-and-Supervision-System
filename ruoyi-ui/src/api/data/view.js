import request from '@/utils/request'

// 查询日程进度
export function getProgress() {
  return request({
    url: '/data/view/progress',
    method: 'get'
  })
}

// 查询完成时长
export function getTotalLasting() {
  return request({
    url: '/data/view/lasting',
    method: 'get'
  })
}

// 查询评论
export function getComment() {
  return request({
    url: '/data/view/comment',
    method: 'get'
  })
}

// 查询及时率
export function getTimely() {
  return request({
    url: '/data/view/timely',
    method: 'get'
  })
}

// 查询平均分
export function getScore() {
  return request({
    url: '/data/view/score',
    method: 'get'
  })
}

// 查询每月时长
export function getMonthTime() {
  return request({
    url: '/data/view/monthTime',
    method: 'get'
  })
}