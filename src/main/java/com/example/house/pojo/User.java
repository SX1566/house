package com.example.house.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.house.config.BaseEntity;
import lombok.Data;

/**
 * 用户表
 *
 * */
@Data
@TableName("user")
public class User extends BaseEntity {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("user")
    private String user;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;

    @TableField("password")
    private String password;

    @TableField("phone")
    private String phone;

    @TableField("house")
    private long house;

    @TableField("permission")
    private String permission;

    @TableField("type")
    private String type;



}
