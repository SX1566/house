package com.example.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.entity.req.TradeReq;
import com.example.house.entity.resp.TradeResp;

import java.util.List;
public interface TradeService {
    Page<TradeResp> page(TradeReq req);

    int add(TradeReq req);

    int update(TradeReq req);

    TradeResp queryById(Long id);

    int deleteById(Long id);

    int batchDelete(List<Long> ids);
}

