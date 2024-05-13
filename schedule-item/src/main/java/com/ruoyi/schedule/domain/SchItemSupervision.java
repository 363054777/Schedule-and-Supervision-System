package com.ruoyi.schedule.domain;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 日程查看对象 sch_item_implement
 * 
 * @author 王梓仰
 * @date 2024-03-25
 */
public class SchItemSupervision extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日程项目编号 */
    private Long itemId;

    /** 日程项目名 */
    @Excel(name = "日程项目名")
    private String itemName;

    /** 预计开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Excel(name = "预计开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm")
    private Date predictStartTime;

    /** 预计执行时长 */
    @Excel(name = "预计执行时长")
    private BigDecimal predictDurationTime;

    /** 已持续时长 */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "已持续时长", width = 20, dateFormat = "HH:mm:ss")
    private Time lastingTime;

    /** 工作日期 */
    @JsonFormat(pattern = "MM-dd")
    @Excel(name = "预计开始时间", width = 30, dateFormat = "MM-dd")
    private Date workingDay;

    /** 日程数量 */
    private int itemCount;

    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setPredictStartTime(Date predictStartTime) 
    {
        this.predictStartTime = predictStartTime;
    }

    public Date getPredictStartTime() 
    {
        return predictStartTime;
    }
    public void setPredictDurationTime(BigDecimal predictDurationTime) 
    {
        this.predictDurationTime = predictDurationTime;
    }

    public BigDecimal getPredictDurationTime() 
    {
        return predictDurationTime;
    }

    public void setLastingTime(Time lastingTime)
    {
        this.lastingTime = lastingTime;
    }
    public Time getLastingTime()
    {
        return lastingTime;
    }

    public void setWorkingDay(Date workingDay)
    {
        this.workingDay = workingDay;
    }
    public Date getWorkingDay(){
        return workingDay;
    }

    public void setItemCount(int itemCount)
    {
        this.itemCount = itemCount;
    }
    public int getItemCount(){
        return itemCount;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("predictStartTime", getPredictStartTime())
            .append("predictDurationTime", getPredictDurationTime())
            .append("lastingTime", getLastingTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("workingDay", getWorkingDay())
            .append("itemCount", getItemCount())
            .toString();
    }
}
