package com.example.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.house.entity.req.AdminReq;
import com.example.house.entity.resp.AdminResp;
import com.example.house.service.Impl.AdminServiceImpl;

import java.util.List;

public interface  AdminService{
    Page<AdminResp> page(AdminReq req);
    
    int add(AdminReq req);

    int update(AdminReq req);

    int audit(AdminReq req);

    AdminResp queryById(Long id);

    int deleteById(Long id);

    int batchDelete(List<Long> ids);
}
