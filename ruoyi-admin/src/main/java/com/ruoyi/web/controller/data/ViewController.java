package com.ruoyi.web.controller.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.data.domain.Comment;
import com.ruoyi.data.domain.MonthTime;
import com.ruoyi.data.domain.Score;
import com.ruoyi.data.domain.Timely;
import com.ruoyi.data.domain.ViewResult;
import com.ruoyi.data.service.IViewService;

@RestController
@RequestMapping("/data/view")
public class ViewController  extends BaseController{

  @Autowired
  private IViewService viewService;
  
  @PreAuthorize("@ss.hasPermi('schedule:result:list')")
  @GetMapping("/progress")
  public TableDataInfo progress()
  {
    List<ViewResult> list = viewService.selectProgress();
    return getDataTable(list);
  }

  @PreAuthorize("@ss.hasPermi('schedule:result:list')")
  @GetMapping("/lasting")
  public TableDataInfo totalLasting()
  {
    List<ViewResult> list = viewService.selectLasting();
    return getDataTable(list);
  }

  @PreAuthorize("@ss.hasPermi('schedule:result:list')")
  @GetMapping("/comment")
  public TableDataInfo comment()
  {
    List<Comment> list = viewService.selectComment();
    return getDataTable(list);
  }

  @PreAuthorize("@ss.hasPermi('schedule:result:list')")
  @GetMapping("/timely")
  public TableDataInfo timely()
  {
    List<Timely> list = viewService.selectTimely();
    return getDataTable(list);
  }

  @PreAuthorize("@ss.hasPermi('schedule:result:list')")
  @GetMapping("/score")
  public TableDataInfo score()
  {
    List<Score> list = viewService.selectScore();
    return getDataTable(list);
  }

  @PreAuthorize("@ss.hasPermi('schedule:result:list')")
  @GetMapping("/monthTime")
  public TableDataInfo monthTime()
  {
    List<MonthTime> list = viewService.selectMonthTime();
    return getDataTable(list);
  }
}
