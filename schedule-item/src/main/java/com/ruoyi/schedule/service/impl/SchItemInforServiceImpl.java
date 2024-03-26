package com.ruoyi.schedule.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.schedule.mapper.SchItemInforMapper;
import com.ruoyi.schedule.domain.SchItemInfor;
import com.ruoyi.schedule.service.ISchItemInforService;

/**
 * 日程管理Service业务层处理
 * 
 * @author 王梓仰
 * @date 2024-03-24
 */
@Service
public class SchItemInforServiceImpl implements ISchItemInforService 
{
    @Autowired
    private SchItemInforMapper schItemInforMapper;

    /**
     * 查询日程管理
     * 
     * @param itemId 日程管理主键
     * @return 日程管理
     */
    @Override
    public SchItemInfor selectSchItemInforByItemId(Long itemId)
    {
        return schItemInforMapper.selectSchItemInforByItemId(itemId);
    }

    /**
     * 查询日程管理列表
     * 
     * @param schItemInfor 日程管理
     * @return 日程管理
     */
    @Override
    public List<SchItemInfor> selectSchItemInforList(SchItemInfor schItemInfor)
    {
        return schItemInforMapper.selectSchItemInforList(schItemInfor);
    }

    /**
     * 新增日程管理
     * 
     * @param schItemInfor 日程管理
     * @return 结果
     */
    @Override
    public int insertSchItemInfor(SchItemInfor schItemInfor)
    {
        schItemInfor.setCreateTime(DateUtils.getNowDate());
        schItemInfor.setCreateBy(SecurityUtils.getUsername());
        return schItemInforMapper.insertSchItemInfor(schItemInfor);
    }

    /**
     * 修改日程管理
     * 
     * @param schItemInfor 日程管理
     * @return 结果
     */
    @Override
    public int updateSchItemInfor(SchItemInfor schItemInfor)
    {
        schItemInfor.setUpdateTime(DateUtils.getNowDate());
        schItemInfor.setUpdateBy(SecurityUtils.getUsername());
        return schItemInforMapper.updateSchItemInfor(schItemInfor);
    }

    /**
     * 批量删除日程管理
     * 
     * @param itemIds 需要删除的日程管理主键
     * @return 结果
     */
    @Override
    public int deleteSchItemInforByItemIds(Long[] itemIds)
    {
        return schItemInforMapper.deleteSchItemInforByItemIds(itemIds);
    }

    /**
     * 删除日程管理信息
     * 
     * @param itemId 日程管理主键
     * @return 结果
     */
    @Override
    public int deleteSchItemInforByItemId(Long itemId)
    {
        return schItemInforMapper.deleteSchItemInforByItemId(itemId);
    }
}
