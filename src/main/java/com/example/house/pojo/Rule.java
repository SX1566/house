package com.example.house.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.house.config.BaseEntity;
import lombok.Data;

import java.util.Date;
@Data
@TableName("rule")
public class Rule extends BaseEntity {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("type")
    private String type;

    @TableField("min_time")
    private String minTime;

    @TableField("max_time")
    private String maxTime;

    @TableField("refund_date")
    private Date refundDate;

    @TableField("description")
    private String description;

    @TableField("have_invoice")
    private String haveInvoice;

    @TableField("payment")
    private String payment;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("updator")
    private String updator;

    @TableField("creator")
    private String creator;

    @TableField("version")
    private Integer version;

    @TableField("is_delete")
    private Integer isDelete;
}
