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
import com.ruoyi.schedule.domain.SchItemSupervision;
import com.ruoyi.schedule.service.ISchItemSupervisionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 日程查看Controller
 * 
 * @author 王梓仰
 * @date 2024-03-25
 */
@RestController
@RequestMapping("/schedule/supervision")
public class SchItemSupervisionController extends BaseController
{
    @Autowired
    private ISchItemSupervisionService schItemSupervisionService;

    /**
     * 查询日程查看列表
     */
    @PreAuthorize("@ss.hasPermi('schedule:supervision:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchItemSupervision schItemSupervision)
    {
        startPage();
        List<SchItemSupervision> list = schItemSupervisionService.selectSchItemSupervisionList(schItemSupervision);
        return getDataTable(list);
    }

    /**
     * 导出日程查看列表
     */
    @PreAuthorize("@ss.hasPermi('schedule:supervision:export')")
    @Log(title = "日程查看", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SchItemSupervision schItemSupervision)
    {
        List<SchItemSupervision> list = schItemSupervisionService.selectSchItemSupervisionList(schItemSupervision);
        ExcelUtil<SchItemSupervision> util = new ExcelUtil<SchItemSupervision>(SchItemSupervision.class);
        util.exportExcel(response, list, "日程查看数据");
    }

    /**
     * 获取日程查看详细信息
     */
    @PreAuthorize("@ss.hasPermi('schedule:supervision:query')")
    @GetMapping(value = "/{itemId}")
    public AjaxResult getInfo(@PathVariable("itemId") Long itemId)
    {
        return success(schItemSupervisionService.selectSchItemSupervisionByItemId(itemId));
    }

    /**
     * 新增日程查看
     */
    @PreAuthorize("@ss.hasPermi('schedule:supervision:add')")
    @Log(title = "日程查看", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchItemSupervision schItemSupervision)
    {
        return toAjax(schItemSupervisionService.insertSchItemSupervision(schItemSupervision));
    }

    /**
     * 修改日程查看
     */
    @PreAuthorize("@ss.hasPermi('schedule:supervision:edit')")
    @Log(title = "日程查看", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchItemSupervision schItemSupervision)
    {
        return toAjax(schItemSupervisionService.updateSchItemSupervision(schItemSupervision));
    }

    /**
     * 删除日程查看
     */
    @PreAuthorize("@ss.hasPermi('schedule:supervision:remove')")
    @Log(title = "日程查看", businessType = BusinessType.DELETE)
	@DeleteMapping("/{itemIds}")
    public AjaxResult remove(@PathVariable Long[] itemIds)
    {
        return toAjax(schItemSupervisionService.deleteSchItemSupervisionByItemIds(itemIds));
    }

    /**
     * 获取未完成日程
     */
    @PreAuthorize("@ss.hasPermi('schedule:item:list')")
    @GetMapping("/getItemName")
    public AjaxResult getItemName(){
        // List<SchItemInfor> itemNames = schItemSupervisionService.selectSchItemInforList(username);
        return success(schItemSupervisionService.selectSchItemInforList());
    }
}