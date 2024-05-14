package com.ruoyi.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

public class ViewResult extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 日程项目编号 */
    private Long itemId;

    /** 日程项目名 */
    private String itemName;

    /** 预计时间 */
    private Double durationTime;

    /** 进行总时间 */
    private Double totalTime;

    /** 总进行时长 */
    private int totalLasting;

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

    public void setDurationTime(Double durationTime) 
    {
        this.durationTime = durationTime;
    }
    public Double getDurationTime() 
    {
        return durationTime;
    }

    public void setTotalTime(Double totalTime) 
    {
        this.totalTime = totalTime;
    }
    public Double getTotalTime() 
    {
        return totalTime;
    }

    public void setTotalLasting(int totalLasting) 
    {
        this.totalLasting = totalLasting;
    }
    public int getTotalLasting() 
    {
        return totalLasting;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("durationTime", getDurationTime())
            .append("totalTime", getTotalTime())
            .append("totalLasting", getTotalLasting())
            .toString();
    }
}
