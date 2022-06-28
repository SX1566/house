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
    
    
    private String address;
    private String type;
    private double price;
    private String photo;
    private String status;
    private long houseSize;
    private long peopleNumber;
    private long bedNumber;
    private long toiletNumber;
    private String service;
    private long hostId;
    private long auditId;
    private String description;
    private long bedroomNumber;
    private String bedType;


}
