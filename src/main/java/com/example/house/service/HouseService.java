package com.example.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.entity.req.HouseReq;
import com.example.house.entity.resp.HouseResp;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HouseService {
    Page<HouseResp> page(HouseReq req);
    
    int add(HouseReq req);

    int update(HouseReq req);

    int audit(HouseReq req);

    HouseResp queryById(Long id);

    int deleteById(Long id);

    int batchDelete(List<Long> ids);
}
