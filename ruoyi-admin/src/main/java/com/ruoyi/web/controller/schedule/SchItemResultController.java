package com.ruoyi.web.controller.schedule;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.schedule.domain.SchItemResult;
import com.ruoyi.schedule.domain.SchItemSupervision;
import com.ruoyi.schedule.service.ISchItemResultService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 日程结果Controller
 * 
 * @author 王梓仰
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/schedule/result")
public class SchItemResultController extends BaseController
{
    @Autowired
    private ISchItemResultService schItemResultService;

    /**
     * 查询日程结果列表
     */
    @PreAuthorize("@ss.hasPermi('schedule:result:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchItemResult schItemResult)
    {
        startPage();
        List<SchItemResult> list = schItemResultService.selectSchItemResultList(schItemResult);
        return getDataTable(list);
    }

    /**
     * 导出日程结果列表
     */
    @PreAuthorize("@ss.hasPermi('schedule:result:export')")
    @Log(title = "日程结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SchItemResult schItemResult)
    {
        List<SchItemResult> list = schItemResultService.selectSchItemResultList(schItemResult);
        ExcelUtil<SchItemResult> util = new ExcelUtil<SchItemResult>(SchItemResult.class);
        util.exportExcel(response, list, "日程结果数据");
    }

    /**
     * 获取日程结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('schedule:result:query')")
    @GetMapping(value = "/{resultId}")
    public AjaxResult getInfo(@PathVariable("resultId") Long resultId)
    {
        return success(schItemResultService.selectSchItemResultByResultId(resultId));
    }

    /**
     * 新增日程结果
     */
    @PreAuthorize("@ss.hasPermi('schedule:result:add')")
    @Log(title = "日程结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchItemResult schItemResult)
    {
        return toAjax(schItemResultService.insertSchItemResult(schItemResult));
    }

    /**
     * 修改日程结果
     */
    @PreAuthorize("@ss.hasPermi('schedule:result:edit')")
    @Log(title = "日程结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchItemResult schItemResult)
    {
        return toAjax(schItemResultService.updateSchItemResult(schItemResult));
    }

    /**
     * 删除日程结果
     */
    @PreAuthorize("@ss.hasPermi('schedule:result:remove')")
    @Log(title = "日程结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{resultIds}")
    public AjaxResult remove(@PathVariable Long[] resultIds)
    {
        return toAjax(schItemResultService.deleteSchItemResultByResultIds(resultIds));
    }

    @PreAuthorize("@ss.hasPermi('schedule:result:add')")
    @Log(title = "日程结果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult addFromSupervision(@RequestBody SchItemSupervision schItemSupervision)
    {
        return toAjax(schItemResultService.insertSchItemResultFromSupervision(schItemSupervision));
        
    }
}
