package com.example.house.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.common.BaseResult;
import com.example.house.entity.req.AdminReq;
import com.example.house.entity.resp.AdminResp;
import com.example.house.service.AdminService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/AdminHouse")
public class AdminController {

    @Autowired AdminService service;
            
    @PostMapping(value = "/query")
    @ApiOperation("查询房屋")
    public BaseResult<Page<AdminResp>> page(@RequestBody AdminReq adminReq){
        return BaseResult.ok(service.page(adminReq));
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增")
    public BaseResult<Integer> add(@RequestBody @Validated AdminReq adminReq){
        return BaseResult.ok(service.add(adminReq));
    }

    @GetMapping(value = "/queryById")
    @ApiOperation("按主键查询")
    public BaseResult<AdminResp> queryById(@RequestParam Long id){
        return BaseResult.ok(service.queryById(id));
    }
    
    @DeleteMapping(value = "/deleteById")
    @ApiOperation("按主键删除")
    public BaseResult<Integer> deleteById(@RequestParam Long id){
        return BaseResult.ok(service.deleteById(id));
    }

    @PostMapping(value = "/audit")
    @ApiOperation("审核房屋")
    public BaseResult<Integer> audit(@RequestBody @Validated AdminReq adminReq){
        return BaseResult.ok(service.audit(adminReq));
    }

    @PostMapping(value = "/batchDelete")
    @ApiOperation("批量删除")
    public BaseResult<Integer> audit(@RequestBody @Validated List<Long> ids){
        return BaseResult.ok(service.batchDelete(ids));
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新")
    public BaseResult<Integer> update(@RequestBody @Validated AdminReq adminReq){
        return BaseResult.ok(service.update(adminReq));

    }
}
