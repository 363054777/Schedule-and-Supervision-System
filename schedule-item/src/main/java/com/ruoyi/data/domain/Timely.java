package com.ruoyi.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

public class Timely extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 日程项目编号 */
    private Long itemId;

    /** 日程项目名 */
    private String itemName;

    /** 及时次数 */
    private int timelySum;

    /** 总日程数 */
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

    public void setTimelySum(int timelySum) 
    {
        this.timelySum = timelySum;
    }
    public int getTimelySum() 
    {
        return timelySum;
    }

    public void setItemCount(int itemCount) 
    {
        this.itemCount = itemCount;
    }
    public int getItemCount() 
    {
        return itemCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("timelySum", getTimelySum())
            .append("itemCount", getItemCount())
            .toString();
    }
}
