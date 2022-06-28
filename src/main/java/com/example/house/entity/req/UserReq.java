package com.example.house.entity.req;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.house.config.QueryBase;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User web响应参数", description = "用户信息表 web响应参数")
public class UserReq extends QueryBase{

    @ApiModelProperty("主键id")
    private long id;

    @ApiModelProperty("用户")
    private String user;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("房屋ID")
    private long house;

    @ApiModelProperty("权限 0无法登录 1无法创建发布 2正常用户 3管理员")
    private String permission;

    @ApiModelProperty("账户类型")
    private String type;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;

    @ApiModelProperty("修改人")
    private String updator;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("版本号")
    private Integer version;

    @ApiModelProperty("逻辑删除状态 0未删除 1已删除")
    private Integer isDelete;
}
