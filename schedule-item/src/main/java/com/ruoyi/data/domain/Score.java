package com.ruoyi.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

public class Score extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 日程项目编号 */
    private Long itemId;

    /** 日程项目名 */
    private String itemName;

    /** 平均得分 */
    private Double avgScore;

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

    public void setAvgScore(double avgScore) 
    {
        this.avgScore = avgScore;
    }
    public double getAvgScore() 
    {
        return avgScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("avgScore", getAvgScore())
            .toString();
    }
}
