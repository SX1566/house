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
@ApiModel(value = "Trade web响应参数", description = "租房信息表 web响应参数")
public class TradeReq extends QueryBase{

    @ApiModelProperty("主键id")
    private long id;

    @ApiModelProperty("租客id")
    private long clientId;

    @ApiModelProperty("房东id")
    private long hostId;

    @ApiModelProperty("房屋id")
    private long houseId;

    @ApiModelProperty("交易时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date tradeTime;

    @ApiModelProperty("价格")
    private long price;

    @ApiModelProperty("入住时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date checkInTime;

    @ApiModelProperty("退房时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date checkOutTime;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("描述")
    private String description;

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
