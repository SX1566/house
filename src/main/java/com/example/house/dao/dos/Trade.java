package com.example.house.dao.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private long id;

    @TableField("client_id")
    private long clientId;

    @TableField("host_id")
    private long hostId;

    @TableField("house_id")
    private long houseId;

    @TableField("trade_time")
    private Date tradeTime;

    @TableField("price")
    private long price;

    @TableField("check_in_time")
    private Date checkInTime;

    @TableField("check_out_time")
    private Date checkOutTime;

    @TableField("status")
    private String status;

    @TableField("description")
    private String description;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("updator")
    private String updator;

    @TableField("creator")
    private String creator;

    @TableField("version")
    private long version;

    @TableField("is_delete")
    private long isDelete;
}
