package com.example.house.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.common.BaseResult;
import com.example.house.entity.req.RuleReq;
import com.example.house.entity.req.TradeReq;
import com.example.house.entity.resp.RuleResp;
import com.example.house.entity.resp.TradeResp;
import com.example.house.service.RuleService;
import com.example.house.service.TradeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {
    @Autowired
    TradeService service;

    @PostMapping(value = "/query")
    @ApiOperation("查询房屋")
    public BaseResult<Page<TradeResp>> page(@RequestBody TradeReq tradeReq){
        return BaseResult.ok(service.page(tradeReq));
    }

    @PostMapping(value = "/add")
    @ApiOperation("新增")
    public BaseResult<Integer> add(@RequestBody @Validated TradeReq tradeReq){
        return BaseResult.ok(service.add(tradeReq));
    }

    @GetMapping(value = "/queryById")
    @ApiOperation("按主键查询")
    public BaseResult<TradeResp> queryById(@RequestParam Long id){
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
    public BaseResult<Integer> update(@RequestBody @Validated TradeReq tradeReq){
        return BaseResult.ok(service.update(tradeReq));
    }
}
