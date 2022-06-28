package com.example.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.entity.req.RuleReq;
import com.example.house.entity.req.UserReq;
import com.example.house.entity.resp.RuleResp;
import com.example.house.entity.resp.UserResp;

import java.util.List;

public interface UserService {
    Page<UserResp> page(UserReq req);

    int add(UserReq req);

    int update(UserReq req);

    UserResp queryById(Long id);

    int deleteById(Long id);

    int batchDelete(List<Long> ids);
}
