package com.ruoyi.schedule.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 日程结果对象 sch_item_result
 * 
 * @author 王梓仰
 * @date 2024-04-07
 */
public class SchItemResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 结果编号 */
    private Long resultId;

    /** 日程项编号 */
    @Excel(name = "日程项编号")
    private Long itemId;

    /** 预计开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date predictStartTime;

    /** 结束时间 */
    private Date finishTime;

    /** 是否及时打卡（0不及时 1及时） */
    @Excel(name = "是否及时打卡", readConverterExp = "0=不及时,1=及时")
    private String ifTimely;

    /** 持续时长 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "持续时长", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastingTime;

    /** 设定总时长 */
    @Excel(name = "设定总时长")
    private BigDecimal totalSetTime;

    /** 日程项评分 */
    @Excel(name = "日程项评分")
    private BigDecimal score;

    /** 日程项评价 */
    @Excel(name = "日程项评价")
    private String comment;

    public void setResultId(Long resultId) 
    {
        this.resultId = resultId;
    }

    public Long getResultId() 
    {
        return resultId;
    }
    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setPredictStartTime(Date predictStartTime) 
    {
        this.predictStartTime = predictStartTime;
    }

    public Date getPredictStartTime() 
    {
        return predictStartTime;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }
    public void setIfTimely(String ifTimely) 
    {
        this.ifTimely = ifTimely;
    }

    public String getIfTimely() 
    {
        return ifTimely;
    }
    public void setLastingTime(Date lastingTime) 
    {
        this.lastingTime = lastingTime;
    }

    public Date getLastingTime() 
    {
        return lastingTime;
    }
    public void setTotalSetTime(BigDecimal totalSetTime) 
    {
        this.totalSetTime = totalSetTime;
    }

    public BigDecimal getTotalSetTime() 
    {
        return totalSetTime;
    }
    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resultId", getResultId())
            .append("itemId", getItemId())
            .append("predictStartTime", getPredictStartTime())
            .append("finishTime", getFinishTime())
            .append("ifTimely", getIfTimely())
            .append("lastingTime", getLastingTime())
            .append("totalSetTime", getTotalSetTime())
            .append("score", getScore())
            .append("comment", getComment())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
