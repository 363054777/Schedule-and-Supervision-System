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
import com.ruoyi.schedule.domain.SchItemInfor;
import com.ruoyi.schedule.service.ISchItemInforService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 日程管理Controller
 * 
 * @author 王梓仰
 * @date 2024-03-23
 */
@RestController
@RequestMapping("/schedule/item")
public class SchItemInforController extends BaseController
{
    @Autowired
    private ISchItemInforService schItemInforService;

    /**
     * 查询日程管理列表
     */
    @PreAuthorize("@ss.hasPermi('schedule:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchItemInfor schItemInfor)
    {
        startPage();
        List<SchItemInfor> list = schItemInforService.selectSchItemInforList(schItemInfor);
        return getDataTable(list);
    }

    /**
     * 导出日程管理列表
     */
    @PreAuthorize("@ss.hasPermi('schedule:item:export')")
    @Log(title = "日程管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SchItemInfor schItemInfor)
    {
        List<SchItemInfor> list = schItemInforService.selectSchItemInforList(schItemInfor);
        ExcelUtil<SchItemInfor> util = new ExcelUtil<SchItemInfor>(SchItemInfor.class);
        util.exportExcel(response, list, "日程管理数据");
    }

    /**
     * 获取日程管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('schedule:item:query')")
    @GetMapping(value = "/{itemId}")
    public AjaxResult getInfo(@PathVariable("itemId") Long itemId)
    {
        return success(schItemInforService.selectSchItemInforByItemId(itemId));
    }

    /**
     * 新增日程管理
     */
    @PreAuthorize("@ss.hasPermi('schedule:item:add')")
    @Log(title = "日程管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchItemInfor schItemInfor)
    {
        return toAjax(schItemInforService.insertSchItemInfor(schItemInfor));
    }

    /**
     * 修改日程管理
     */
    @PreAuthorize("@ss.hasPermi('schedule:item:edit')")
    @Log(title = "日程管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchItemInfor schItemInfor)
    {
        return toAjax(schItemInforService.updateSchItemInfor(schItemInfor));
    }

    /**
     * 删除日程管理
     */
    @PreAuthorize("@ss.hasPermi('schedule:item:remove')")
    @Log(title = "日程管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{itemIds}")
    public AjaxResult remove(@PathVariable Long[] itemIds)
    {
        return toAjax(schItemInforService.deleteSchItemInforByItemIds(itemIds));
    }
}
