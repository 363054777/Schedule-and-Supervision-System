package com.ruoyi.schedule.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.schedule.mapper.SchItemInforMapper;
import com.ruoyi.schedule.mapper.SchItemSupervisionMapper;
import com.ruoyi.schedule.domain.SchItemInfor;
import com.ruoyi.schedule.domain.SchItemResult;
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

    @Autowired
    private SchItemInforMapper schItemInforMapper;

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
        return schItemSupervisionMapper.selectSchItemSupervisionList(schItemSupervision, SecurityUtils.getUsername());
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
        schItemSupervision.setCreateBy(SecurityUtils.getUsername());
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
        schItemSupervision.setUpdateBy(SecurityUtils.getUsername());
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

    /**
     * 获取可用日程
     * 
     * @param username 日程查看主键
     * @return 结果
     */
    @Override
    public List<SchItemInfor> selectSchItemInforList() {
        return schItemInforMapper.getValidItem(SecurityUtils.getUsername());
    }

    /**
     * 新增日程结果
     * 
     * @param SchItemSupervision 日程结果
     * @return 结果
     */
    @Override
    public List<SchItemSupervision> countItemByDate() {
        return schItemSupervisionMapper.getItemCount(SecurityUtils.getUsername());
    }
}
