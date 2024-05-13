package com.ruoyi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.schedule.domain.SchItemSupervision;
import com.ruoyi.schedule.service.ISchItemSupervisionService;

/**
 * 日程结果Controller
 * 
 * @author 王梓仰
 * @date 2024-04-07
 */

@RestController
@RequestMapping("/index")
public class IndexController  extends BaseController{

  @Autowired
    private ISchItemSupervisionService schItemSupervisionService;

    /**
     * 查询日程查看列表
     */
    @PreAuthorize("@ss.hasPermi('schedule:supervision:list')")
    @GetMapping("/getItemCount")
    public TableDataInfo list(SchItemSupervision schItemSupervision)
    {
        // startPage();
        List<SchItemSupervision> list = schItemSupervisionService.countItemByDate();
        return getDataTable(list);
    }
  
}
