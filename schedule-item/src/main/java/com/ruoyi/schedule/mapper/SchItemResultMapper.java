package com.ruoyi.schedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.schedule.domain.SchItemResult;
import com.ruoyi.schedule.domain.SchItemSupervision;

/**
 * 日程结果Mapper接口
 * 
 * @author 王梓仰
 * @date 2024-04-07
 */
public interface SchItemResultMapper 
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
    public List<SchItemResult> selectSchItemResultList(@Param("schItemResult")SchItemResult schItemResult,  @Param("username")String username);

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
     * 删除日程结果
     * 
     * @param resultId 日程结果主键
     * @return 结果
     */
    public int deleteSchItemResultByResultId(Long resultId);

    /**
     * 批量删除日程结果
     * 
     * @param resultIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSchItemResultByResultIds(Long[] resultIds);

    public int insertSchItemResultFromSupervision(SchItemSupervision schItemSupervision);
}
