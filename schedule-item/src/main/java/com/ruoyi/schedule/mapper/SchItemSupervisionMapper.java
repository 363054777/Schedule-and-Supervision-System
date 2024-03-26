package com.ruoyi.schedule.mapper;

import java.util.List;

import com.ruoyi.schedule.domain.SchItemSupervision;

/**
 * 日程查看Mapper接口
 * 
 * @author 王梓仰
 * @date 2024-03-25
 */
public interface SchItemSupervisionMapper 
{
    /**
     * 查询日程查看
     * 
     * @param itemId 日程查看主键
     * @return 日程查看
     */
    public SchItemSupervision selectSchItemSupervisionByItemId(Long itemId);

    /**
     * 查询日程查看列表
     * 
     * @param schItemSupervision 日程查看
     * @return 日程查看集合
     */
    public List<SchItemSupervision> selectSchItemSupervisionList(SchItemSupervision schItemSupervision);

    /**
     * 新增日程查看
     * 
     * @param schItemSupervision 日程查看
     * @return 结果
     */
    public int insertSchItemSupervision(SchItemSupervision schItemSupervision);

    /**
     * 修改日程查看
     * 
     * @param schItemSupervision 日程查看
     * @return 结果
     */
    public int updateSchItemSupervision(SchItemSupervision schItemSupervision);

    /**
     * 删除日程查看
     * 
     * @param itemId 日程查看主键
     * @return 结果
     */
    public int deleteSchItemSupervisionByItemId(Long itemId);

    /**
     * 批量删除日程查看
     * 
     * @param itemIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSchItemSupervisionByItemIds(Long[] itemIds);

    public Long getItemByName(String itemName);
}
