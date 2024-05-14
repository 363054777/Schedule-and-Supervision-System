package com.ruoyi.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

public class MonthTime extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 月份 */
    private String month;

    /** 每月时长 */
    private Double totalTime;

    public void setMonth(String month) 
    {
        this.month = month;
    }
    public String getMonth() 
    {
        return month;
    }

    public void setTotalTime(double totalTime) 
    {
        this.totalTime = totalTime;
    }
    public double getTotalTime() 
    {
        return totalTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("month", getMonth())
            .append("totalTime", getTotalTime())
            .toString();
    }
}
