package com.ruoyi.schedule.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.schedule.mapper.SchItemResultMapper;
import com.ruoyi.schedule.domain.SchItemResult;
import com.ruoyi.schedule.domain.SchItemSupervision;
import com.ruoyi.schedule.service.ISchItemResultService;

/**
 * 日程结果Service业务层处理
 * 
 * @author 王梓仰
 * @date 2024-04-07
 */
@Service
public class SchItemResultServiceImpl implements ISchItemResultService 
{
    @Autowired
    private SchItemResultMapper schItemResultMapper;

    /**
     * 查询日程结果
     * 
     * @param resultId 日程结果主键
     * @return 日程结果
     */
    @Override
    public SchItemResult selectSchItemResultByResultId(Long resultId)
    {
        return schItemResultMapper.selectSchItemResultByResultId(resultId);
    }

    /**
     * 查询日程结果列表
     * 
     * @param schItemResult 日程结果
     * @return 日程结果
     */
    @Override
    public List<SchItemResult> selectSchItemResultList(SchItemResult schItemResult)
    {
        return schItemResultMapper.selectSchItemResultList(schItemResult, SecurityUtils.getUsername());
    }

    /**
     * 新增日程结果
     * 
     * @param schItemResult 日程结果
     * @return 结果
     */
    @Override
    public int insertSchItemResult(SchItemResult schItemResult)
    {
        schItemResult.setCreateTime(DateUtils.getNowDate());
        schItemResult.setCreateBy(SecurityUtils.getUsername());
        return schItemResultMapper.insertSchItemResult(schItemResult);
    }

    /**
     * 修改日程结果
     * 
     * @param schItemResult 日程结果
     * @return 结果
     */
    @Override
    public int updateSchItemResult(SchItemResult schItemResult)
    {
        schItemResult.setUpdateTime(DateUtils.getNowDate());
        schItemResult.setUpdateBy(SecurityUtils.getUsername());
        return schItemResultMapper.updateSchItemResult(schItemResult);
    }

    /**
     * 批量删除日程结果
     * 
     * @param resultIds 需要删除的日程结果主键
     * @return 结果
     */
    @Override
    public int deleteSchItemResultByResultIds(Long[] resultIds)
    {
        return schItemResultMapper.deleteSchItemResultByResultIds(resultIds);
    }

    /**
     * 删除日程结果信息
     * 
     * @param resultId 日程结果主键
     * @return 结果
     */
    @Override
    public int deleteSchItemResultByResultId(Long resultId)
    {
        return schItemResultMapper.deleteSchItemResultByResultId(resultId);
    }

    /**
     * 新增日程结果
     * 
     * @param SchItemSupervision 日程结果
     * @return 结果
     */
    @Override
    public int insertSchItemResultFromSupervision(SchItemSupervision schItemSupervision)
    {
        SchItemResult schItemResult = new SchItemResult();
        schItemResult.setCreateTime(DateUtils.getNowDate());
        schItemResult.setCreateBy(SecurityUtils.getUsername());
        schItemResult.setItemId(schItemSupervision.getItemId());
        schItemResult.setPredictStartTime(schItemSupervision.getPredictStartTime());
        schItemResult.setFinishTime(new Date());
        schItemResult.setLastingTime(schItemSupervision.getLastingTime());
        schItemResult.setTotalSetTime(schItemSupervision.getPredictDurationTime());
        Date startDate = schItemResult.getPredictStartTime();
        Date endDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if(format.format(startDate).equals(format.format(endDate)))
        {
            schItemResult.setIfTimely("1");
        }
        else
        {
            schItemResult.setIfTimely("0");
        }
        return schItemResultMapper.insertSchItemResult(schItemResult);
    }
}
