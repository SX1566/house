package com.example.house.dao.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.house.config.BaseEntity;
import lombok.Data;

import java.util.Date;
/**
 * 交易表
 *
 * */
@Data
@TableName("trade")
public class Trade extends BaseEntity {

    private long id;
    private long clientId;
    private long hostId;
    private long houseId;
    private Date tradeTime;
    private long price;
    private Date checkInTime;
    private Date checkOutTime;
    private String status;
    private String description;
    private Date createTime;
    private Date updateTime;
    private String updator;
    private String creator;
    private long version;
    private long isDelete;
}
