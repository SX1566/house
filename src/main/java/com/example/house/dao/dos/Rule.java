package com.example.house.dao.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.house.config.BaseEntity;
import lombok.Data;

/**
 * 规则表
 * 
 * */

import java.util.Date;
@Data
@TableName("rule")
public class Rule extends BaseEntity {

    private long id;
    private String type;
    private String minTime;
    private String maxTime;
    private Date refundDate;
    private String description;
    private String haveInvoice;
    private String payment;
    private Date createTime;
    private Date updateTime;
    private String updator;
    private String creator;
    private long version;
    private long isDelete;
}
