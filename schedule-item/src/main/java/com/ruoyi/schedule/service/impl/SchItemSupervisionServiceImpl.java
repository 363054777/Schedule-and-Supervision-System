package com.ruoyi.schedule.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.schedule.mapper.SchItemSupervisionMapper;
import com.ruoyi.schedule.domain.SchItemInfor;
import com.ruoyi.schedule.domain.SchItemSupervision;
import com.ruoyi.schedule.service.ISchItemSupervisionService;

/**
 * 日程查看Service业务层处理
 * 
 * @author 王梓仰
 * @date 2024-03-25
 */
@Service
public class SchItemSupervisionServiceImpl implements ISchItemSupervisionService {
    @Autowired
    private SchItemSupervisionMapper schItemSupervisionMapper;

    /**
     * 查询日程查看
     * 
     * @param itemId 日程查看主键
     * @return 日程查看
     */
    @Override
    public SchItemSupervision selectSchItemSupervisionByItemId(Long itemId) {
        return schItemSupervisionMapper.selectSchItemSupervisionByItemId(itemId);
    }

    /**
     * 查询日程查看列表
     * 
     * @param schItemSupervision 日程查看
     * @return 日程查看
     */
    @Override
    public List<SchItemSupervision> selectSchItemSupervisionList(SchItemSupervision schItemSupervision) {
        return schItemSupervisionMapper.selectSchItemSupervisionList(schItemSupervision);
    }

    /**
     * 新增日程查看
     * 
     * @param schItemSupervision 日程查看
     * @return 结果
     */
    @Override
    public int insertSchItemSupervision(SchItemSupervision schItemSupervision) {
        schItemSupervision.setCreateTime(DateUtils.getNowDate());
        schItemSupervision.setItemId(getItemByName(schItemSupervision.getItemName()));
        return schItemSupervisionMapper.insertSchItemSupervision(schItemSupervision);
    }

    /**
     * 修改日程查看
     * 
     * @param schItemSupervision 日程查看
     * @return 结果
     */
    @Override
    public int updateSchItemSupervision(SchItemSupervision schItemSupervision) {
        schItemSupervision.setUpdateTime(DateUtils.getNowDate());
        return schItemSupervisionMapper.updateSchItemSupervision(schItemSupervision);
    }

    /**
     * 批量删除日程查看
     * 
     * @param itemIds 需要删除的日程查看主键
     * @return 结果
     */
    @Override
    public int deleteSchItemSupervisionByItemIds(Long[] itemIds) {
        return schItemSupervisionMapper.deleteSchItemSupervisionByItemIds(itemIds);
    }

    /**
     * 删除日程查看信息
     * 
     * @param itemId 日程查看主键
     * @return 结果
     */
    @Override
    public int deleteSchItemSupervisionByItemId(Long itemId) {
        return schItemSupervisionMapper.deleteSchItemSupervisionByItemId(itemId);
    }

    @Override
    public Long getItemByName(String itemName) {
        return schItemSupervisionMapper.getItemByName(itemName);
    }
}
