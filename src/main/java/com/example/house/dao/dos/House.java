package com.example.house.dao.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.house.config.BaseEntity;
import lombok.Data;

/**
 * 房屋信息表
 *
 * */
@Data
@TableName("house")
public class House extends BaseEntity {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private long id;
    
    @TableField("name")
    private String name;

    @TableField("address")
    private String address;

    @TableField("type")
    private String type;

    @TableField("price")
    private double price;

    @TableField("photo")
    private String photo;

    @TableField("status")
    private String status;

    @TableField("house_size")
    private long houseSize;

    @TableField("people_number")
    private long peopleNumber;

    @TableField("bed_number")
    private long bedNumber;

    @TableField("toilet_number")
    private long toiletNumber;

    @TableField("service")
    private String service;

    @TableField("host_id")
    private long hostId;

    @TableField("audit_id")
    private long auditId;

    @TableField("description")
    private String description;

    @TableField("bedroom_number")
    private long bedroomNumber;

    @TableField("bed_type")
    private String bedType;


}
