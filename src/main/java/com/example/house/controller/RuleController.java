package com.example.house.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.common.BaseResult;
import com.example.house.entity.req.RuleReq;
import com.example.house.entity.resp.RuleResp;
import com.example.house.service.RuleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    RuleService service;

    @PostMapping(value = "/query")
    @ApiOperation("查询房屋")
    public BaseResult<Page<RuleResp>> page(@RequestBody RuleReq ruleReq){
        return BaseResult.ok(service.page(ruleReq));
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增")
    public BaseResult<Integer> add(@RequestBody @Validated RuleReq ruleReq){
        return BaseResult.ok(service.add(ruleReq));
    }

    @GetMapping(value = "/queryById")
    @ApiOperation("按主键查询")
    public BaseResult<RuleResp> queryById(@RequestParam Long id){
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
    public BaseResult<Integer> update(@RequestBody @Validated RuleReq ruleReq){
        return BaseResult.ok(service.update(ruleReq));
    }
}
