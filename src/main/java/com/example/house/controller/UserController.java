package com.example.house.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.common.BaseResult;
import com.example.house.entity.req.UserReq;
import com.example.house.entity.resp.UserResp;
import com.example.house.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping(value = "/query")
    @ApiOperation("查询房屋")
    public BaseResult<Page<UserResp>> page(@RequestBody UserReq userReq){
        return BaseResult.ok(service.page(userReq));
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增")
    public BaseResult<Integer> add(@RequestBody @Validated UserReq userReq){
        return BaseResult.ok(service.add(userReq));
    }

    @GetMapping(value = "/queryById")
    @ApiOperation("按主键查询")
    public BaseResult<UserResp> queryById(@RequestParam Long id){
        return BaseResult.ok(service.queryById(id));
    }

    @DeleteMapping(value = "/deleteById")
    @ApiOperation("按主键删除")
    public BaseResult<Integer> deleteById(@RequestParam Long id){
        return BaseResult.ok(service.deleteById(id));
    }

    @PostMapping(value = "/batchDelete")
    @ApiOperation("批量删除")
    public BaseResult<Integer> audit(@RequestBody @Validated List<Long> ids){
        return BaseResult.ok(service.batchDelete(ids));
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新")
    public BaseResult<Integer> update(@RequestBody @Validated UserReq userReq){
        return BaseResult.ok(service.update(userReq));
    }
}
