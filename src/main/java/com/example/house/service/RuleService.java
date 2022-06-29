package com.example.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.entity.req.RuleReq;
import com.example.house.entity.resp.RuleResp;

import java.util.List;

public interface RuleService {
    Page<RuleResp> page(RuleReq req);

    List<RuleResp> listAll(RuleReq req);
    
    int add(RuleReq req);

    int update(RuleReq req);

    RuleResp queryById(Long id);

    int deleteById(Long id);

    int batchDelete(List<Long> ids);
}
