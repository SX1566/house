package com.example.house.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.common.BaseResult;
import com.example.house.entity.req.HouseReq;
import com.example.house.entity.resp.HouseResp;
import com.example.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService service;
            
    @PostMapping(value = "/query")
    @ApiOperation("查询房屋")
    public BaseResult<Page<HouseResp>> page(@RequestBody HouseReq housereq){
        return BaseResult.ok(service.page(housereq));
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增")
    public BaseResult<Integer> add(@RequestBody @Validated HouseReq housereq){
        return BaseResult.ok(service.add(housereq));
    }

    @GetMapping(value = "/queryById")
    @ApiOperation("按主键查询")
    public BaseResult<HouseResp> queryById(@RequestParam Long id){
        return BaseResult.ok(service.queryById(id));
    }
    
    @DeleteMapping(value = "/deleteById")
    @ApiOperation("按主键删除")
    public BaseResult<Integer> deleteById(@RequestParam Long id){
        return BaseResult.ok(service.deleteById(id));
    }

    @PostMapping(value = "/audit")
    @ApiOperation("审核房屋")
    public BaseResult<Integer> audit(@RequestBody @Validated HouseReq housereq){
        return BaseResult.ok(service.audit(housereq));
    }

    @PostMapping(value = "/batchDelete")
    @ApiOperation("批量删除")
    public BaseResult<Integer> audit(@RequestBody @Validated List<Long> ids){
        return BaseResult.ok(service.batchDelete(ids));
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新")
    public BaseResult<Integer> update(@RequestBody @Validated HouseReq housereq){
        return BaseResult.ok(service.update(housereq));

    }
}
