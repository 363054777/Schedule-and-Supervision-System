package com.ruoyi.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.data.domain.Comment;
import com.ruoyi.data.domain.MonthTime;
import com.ruoyi.data.domain.Score;
import com.ruoyi.data.domain.Timely;
import com.ruoyi.data.domain.ViewResult;
import com.ruoyi.data.mapper.ViewMapper;
import com.ruoyi.data.service.IViewService;

@Service
public class ViewServiceImpl implements IViewService {

  @Autowired
  private ViewMapper viewMapper;

  @Override
  public List<ViewResult> selectProgress() {
    return viewMapper.selectProgress(SecurityUtils.getUsername());
  }

  @Override
  public List<ViewResult> selectLasting() {
    // TODO Auto-generated method stub
    return viewMapper.selectLasting(SecurityUtils.getUsername());
  }

  @Override
  public List<Comment> selectComment() {
    // TODO Auto-generated method stub
    return viewMapper.selectComment(SecurityUtils.getUsername());
  }

  @Override
  public List<Timely> selectTimely() {
    // TODO Auto-generated method stub
    return viewMapper.selectTimely(SecurityUtils.getUsername());
  }

  @Override
  public List<Score> selectScore() {
    // TODO Auto-generated method stub
    return viewMapper.selectScore(SecurityUtils.getUsername());
  }

  @Override
  public List<MonthTime> selectMonthTime() {
    // TODO Auto-generated method stub
    return viewMapper.selectMonthTime(SecurityUtils.getUsername());
  }
  
}
