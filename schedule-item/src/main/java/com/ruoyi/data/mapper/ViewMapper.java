package com.ruoyi.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.data.domain.ViewResult;
import com.ruoyi.data.domain.Comment;
import com.ruoyi.data.domain.MonthTime;
import com.ruoyi.data.domain.Score;
import com.ruoyi.data.domain.Timely;

public interface ViewMapper {
  public List<ViewResult> selectProgress(@Param("username")String username);

  public List<ViewResult> selectLasting(@Param("username") String username);

  public List<Comment> selectComment(@Param("username") String username);

  public List<Timely> selectTimely(@Param("username") String username);

  public List<Score> selectScore(@Param("username") String username);

  public List<MonthTime> selectMonthTime(@Param("username") String username);
}
