package com.ruoyi.schedule.service;

import java.util.List;
import com.ruoyi.schedule.domain.SchItemResult;
import com.ruoyi.schedule.domain.SchItemSupervision;

/**
 * 日程结果Service接口
 * 
 * @author 王梓仰
 * @date 2024-04-07
 */
public interface ISchItemResultService 
{
    /**
     * 查询日程结果
     * 
     * @param resultId 日程结果主键
     * @return 日程结果
     */
    public SchItemResult selectSchItemResultByResultId(Long resultId);

    /**
     * 查询日程结果列表
     * 
     * @param schItemResult 日程结果
     * @return 日程结果集合
     */
    public List<SchItemResult> selectSchItemResultList(SchItemResult schItemResult);

    /**
     * 新增日程结果
     * 
     * @param schItemResult 日程结果
     * @return 结果
     */
    public int insertSchItemResult(SchItemResult schItemResult);

    /**
     * 修改日程结果
     * 
     * @param schItemResult 日程结果
     * @return 结果
     */
    public int updateSchItemResult(SchItemResult schItemResult);

    /**
     * 批量删除日程结果
     * 
     * @param resultIds 需要删除的日程结果主键集合
     * @return 结果
     */
    public int deleteSchItemResultByResultIds(Long[] resultIds);

    /**
     * 删除日程结果信息
     * 
     * @param resultId 日程结果主键
     * @return 结果
     */
    public int deleteSchItemResultByResultId(Long resultId);

    /**
     * 新增日程结果
     * 
     * @param SchItemSupervision 日程结果
     * @return 结果
     */
    public int insertSchItemResultFromSupervision(SchItemSupervision schItemSupervision);
}
