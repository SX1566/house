package com.example.house.controller;

import com.example.house.entity.req.AdminReq;
import com.example.house.entity.resp.AdminResp;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/AdminHouse")
public class AdminController {

    @GetMapping(value = "/query")
    @ApiOperation("查询房屋")
    public BaseResult<Page<AdminReq>> query(@RequestBody AdminResp adminResp){
        return carsTrainServiceApi.query(adminResp);
    }

    @GetMapping(value = "/insert")
    @ApiOperation("新增房屋")
    public BaseResult<Boolean> insert(@RequestBody AdminResp adminResp){
        return carsTrainServiceApi.insert(adminResp);
    }

    @GetMapping(value = "/deleteById")
    @ApiOperation("删除房屋")
    public BaseResult<Integer> deleteById(@RequestBody AdminResp adminResp){
        return carsTrainServiceApi.deleteById(query);
    }

    @GetMapping(value = "/audit")
    @ApiOperation("审核房屋")
    public BaseResult<Integer> audit(@RequestBody AdminResp adminResp){
        return carsTrainServiceApi.pageQuery(query);
    }

    @PostMapping(value = "/update")
    @ApiOperation("修改房屋")
    public BaseResult<Integer> update(@RequestBody AdminResp adminResp){
        return carsTrainServiceApi.updateOrCreateMotorcycleType(query);
    }
}
