package com.ruoyi.data.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

public class Comment extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 日程项目编号 */
    private Long itemId;

    /** 日程项目名 */
    private String itemName;

    /** 预计日期 */
    private Date date;

    /** 评论 */
    private String comment;

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

    public void setDate(Date date) 
    {
        this.date = date;
    }
    public Date getDate() 
    {
        return date;
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
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("date", getDate())
            .append("comment", getComment())
            .toString();
    }
}
