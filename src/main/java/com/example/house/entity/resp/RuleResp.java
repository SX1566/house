package com.example.house.entity.resp;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Rule web响应参数", description = "规则信息表 web响应参数")
public class RuleResp implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private long id;

    @ApiModelProperty("出租类型")
    private String type;

    @ApiModelProperty("最小天数")
    private String minTime;

    @ApiModelProperty("最大天数")
    private String maxTime;

    @ApiModelProperty("全额退款日")
    private Date refundDate;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("是否提供发票 0不提供 1提供")
    private String haveInvoice;

    @ApiModelProperty("付款方式")
    private String payment;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("修改人")
    private String updator;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("版本号")
    private long version;

    @ApiModelProperty("逻辑删除状态 0未删除 1已删除")
    private long isDelete;
}