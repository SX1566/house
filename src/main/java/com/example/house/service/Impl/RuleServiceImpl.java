package com.example.house.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.entity.req.RuleReq;
import com.example.house.entity.resp.RuleResp;
import com.example.house.service.RuleService;

import java.util.List;

public class RuleServiceImpl implements RuleService {
    @Override
    public Page<RuleResp> page(RuleReq req) {
        return null;
    }

    @Override
    public int add(RuleReq req) {
        return 0;
    }

    @Override
    public int update(RuleReq req) {
        return 0;
    }

    @Override
    public RuleResp queryById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int batchDelete(List<Long> ids) {
        return 0;
    }
}
