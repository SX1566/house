package com.example.house.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel("分页查询基础类")
public class QueryBase implements Serializable {
    private static final long serialVersionUID = -7036759249980767928L;
    @ApiModelProperty(
            value = "页号",
            example = "1"
    )
    private int pageNum = 1;
    @ApiModelProperty(
            value = "页大小",
            example = "2"
    )
    private int pageSize = 20;
    @ApiModelProperty(
            hidden = true
    )
    private int offset = 0;
    @ApiModelProperty(
            hidden = true
    )
    private int limit = 20;

    public QueryBase() {
    }

    public QueryBase(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.offset = pageNum <= 0 ? 0 : (pageNum - 1) * pageSize;
        this.limit = pageSize;
    }

    public int getPageNum() {
        return this.pageNum == 0 ? 1 : this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.offset = pageNum <= 0 ? 0 : (pageNum - 1) * this.pageSize;
    }

    public int getPageSize() {
        return this.pageSize == 0 ? 10 : this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.offset = this.pageNum <= 0 ? 0 : (this.pageNum - 1) * pageSize;
        this.limit = pageSize;
    }

    public int getOffset() {
        return this.pageNum <= 0 ? 0 : (this.pageNum - 1) * this.pageSize;
    }

    public int getLimit() {
        return this.pageSize;
    }
}
