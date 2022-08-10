package com.tencent.wxcloudrun.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName home_produce
 */
@TableName(value ="home_produce")
@Data
public class HomeProduce implements Serializable {
    /**
     * 记录id
     */
    @TableId
    private String reduceId;

    private String formUser;

    /**
     * 物品名
     */
    private String produce;

    /**
     * 位置
     */
    private String address;

    /**
     * 
     */
    private Date createtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HomeProduce other = (HomeProduce) that;
        return (this.getReduceId() == null ? other.getReduceId() == null : this.getReduceId().equals(other.getReduceId()))
            && (this.getProduce() == null ? other.getProduce() == null : this.getProduce().equals(other.getProduce()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReduceId() == null) ? 0 : getReduceId().hashCode());
        result = prime * result + ((getProduce() == null) ? 0 : getProduce().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reduceId=").append(reduceId);
        sb.append(", produce=").append(produce);
        sb.append(", address=").append(address);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}