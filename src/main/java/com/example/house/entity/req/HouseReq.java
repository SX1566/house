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

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("价格")
    private double price;

    @ApiModelProperty("照片")
    private String photo;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("房屋大小")
    private Integer houseSize;

    @ApiModelProperty("最大容纳人数")
    private Integer peopleNumber;

    @ApiModelProperty("床位数")
    private Integer bedNumber;

    @ApiModelProperty("卫生间数")
    private Integer toiletNumber;

    @ApiModelProperty("设施服务")
    private String service;

    @ApiModelProperty("房主ID")
    private Integer hostId;

    @ApiModelProperty("管理员ID")
    private Integer auditId;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("卧室数")
    private Integer bedroomNumber;

    @ApiModelProperty("床型")
    private String bedType;

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
