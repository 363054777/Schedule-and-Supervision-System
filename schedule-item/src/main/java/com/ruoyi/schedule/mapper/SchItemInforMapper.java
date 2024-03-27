package com.ruoyi.schedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.schedule.domain.SchItemInfor;

/**
 * 日程管理Mapper接口
 * 
 * @author 王梓仰
 * @date 2024-03-24
 */
public interface SchItemInforMapper 
{
    /**
     * 查询日程管理
     * 
     * @param itemId 日程管理主键
     * @return 日程管理
     */
    public SchItemInfor selectSchItemInforByItemId(Long itemId);

    /**
     * 查询日程管理列表
     * 
     * @param schItemInfor 日程管理
     * @return 日程管理集合
     */
    public List<SchItemInfor> selectSchItemInforList(@Param("schItemInfor")SchItemInfor schItemInfor, @Param("username")String username);

    /**
     * 新增日程管理
     * 
     * @param schItemInfor 日程管理
     * @return 结果
     */
    public int insertSchItemInfor(SchItemInfor schItemInfor);

    /**
     * 修改日程管理
     * 
     * @param schItemInfor 日程管理
     * @return 结果
     */
    public int updateSchItemInfor(SchItemInfor schItemInfor);

    /**
     * 删除日程管理
     * 
     * @param itemId 日程管理主键
     * @return 结果
     */
    public int deleteSchItemInforByItemId(Long itemId);

    /**
     * 批量删除日程管理
     * 
     * @param itemIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSchItemInforByItemIds(Long[] itemIds);

    /**
     * 获取可用日程
     * 
     * @param username 需要删除的数据主键集合
     * @return 结果
     */
    public List<SchItemInfor> getValidItem(String username);

}