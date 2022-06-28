package com.example.house.entity.req;


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
@ApiModel(value = "House web响应参数", description = "房屋信息表 web响应参数")
public class HouseReq extends QueryBase {

    @ApiModelProperty("主键id")
    private long id;

    //TODO
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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    private Date updateTime;
    private String updator;
    private String creator;
    private long version;
    private long isDelete;


}
