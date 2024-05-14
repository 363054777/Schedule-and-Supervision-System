package com.ruoyi.data.service;

import java.util.List;

import com.ruoyi.data.domain.ViewResult;
import com.ruoyi.data.domain.Comment;
import com.ruoyi.data.domain.MonthTime;
import com.ruoyi.data.domain.Score;
import com.ruoyi.data.domain.Timely;

public interface IViewService {

    /**
    * 查询日程进度
    * 
    * @return 日程查看
    */
    public List<ViewResult> selectProgress();

    /**
    * 查询进行时长
    * 
    * @return 日程查看
    */
    public List<ViewResult> selectLasting();

    /**
    * 查询评论
    * 
    * @return 日程查看
    */
    public List<Comment> selectComment();

    /**
    * 查询及时率
    * 
    * @return 日程查看
    */
    public List<Timely> selectTimely();

    /**
    * 查询平均分
    * 
    * @return 日程查看
    */
    public List<Score> selectScore();

    /**
    * 查询每月时长
    * 
    * @return 日程查看
    */
    public List<MonthTime> selectMonthTime();
}
