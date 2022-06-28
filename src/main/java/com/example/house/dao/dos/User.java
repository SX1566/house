package com.example.house.dao.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.house.config.BaseEntity;
import lombok.Data;

import java.util.Date;
/**
 * 用户表
 *
 * */
@Data
@TableName("user")
public class User extends BaseEntity {

    private long id;
    private String user;
    private String name;
    private String sex;
    private String password;
    private String phone;
    private long house;
    private String permission;
    private String type;



}
