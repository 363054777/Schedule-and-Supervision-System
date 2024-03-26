package com.ruoyi.schedule.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 日程管理对象 sch_item_infor
 * 
 * @author 王梓仰
 * @date 2024-03-25
 */
public class SchItemInfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日程项目编号 */
    private Long itemId;

    /** 日程项目名 */
    @Excel(name = "日程项目名")
    private String itemName;

    /** 起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 日程总共所需时间 */
    @Excel(name = "日程总共所需时间")
    private BigDecimal durationTime;

    /** 日程是否完成（0未完成 1已完成） */
    @Excel(name = "日程是否完成", readConverterExp = "0=未完成,1=已完成")
    private String ifFinished;

    /** 先导日程 */
    @Excel(name = "先导日程")
    private Long previousItemId;

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
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setDurationTime(BigDecimal durationTime) 
    {
        this.durationTime = durationTime;
    }

    public BigDecimal getDurationTime() 
    {
        return durationTime;
    }
    public void setIfFinished(String ifFinished) 
    {
        this.ifFinished = ifFinished;
    }

    public String getIfFinished() 
    {
        return ifFinished;
    }
    public void setPreviousItemId(Long previousItemId) 
    {
        this.previousItemId = previousItemId;
    }

    public Long getPreviousItemId() 
    {
        return previousItemId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("startTime", getStartTime())
            .append("durationTime", getDurationTime())
            .append("ifFinished", getIfFinished())
            .append("previousItemId", getPreviousItemId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
