package com.example.house.entity.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "House web响应参数", description = "房屋信息表 web响应参数")
public class HouseResp implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private long id;
    
    //TODO
    private String name;
    private String address;
    private String type;
    private double price;
    private String photo;
    private String status;
    private Integer houseSize;
    private Integer peopleNumber;
    private Integer bedNumber;
    private Integer toiletNumber;
    private String service;
    private Integer hostId;
    private Integer auditId;
    private String description;
    private Integer bedroomNumber;
    private String bedType;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    
    private Date updateTime;
    private String updator;
    private String creator;
    private Integer version;
    private Integer isDelete;
}
