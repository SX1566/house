package com.example.house.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.dao.dos.Trade;
import com.example.house.dao.mapper.TradeMapper;
import com.example.house.entity.req.TradeReq;
import com.example.house.entity.resp.TradeResp;
import com.example.house.service.TradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeMapper mapper;

    @Override
    public Page<TradeResp> page(TradeReq req) {
        Page<Trade> page = new Page<>(req.getPageNum(), req.getPageSize());
        Page<Trade> resp = mapper.selectPage(page, req2QueryWrapper(req));
        List<TradeResp> records = resp.getRecords().stream().map(this::entity2Resp).collect(Collectors.toList());
        return new Page<TradeResp>(resp.getCurrent(), resp.getSize(), resp.getTotal()).setRecords(records);
    }


    @Override
    @Transactional
    public int add(TradeReq req) {
        Trade trade = req2Entity(req);
        return mapper.insert(trade);
    }

    @Override
    @Transactional
    public int update(TradeReq req) {
        return mapper.updateById(req2Entity(req));
    }


    @Override
    public TradeResp queryById(Long id) {
        Trade entity = mapper.selectById(id);
        if (entity == null) {
            return null;
        }
        TradeResp resp = new TradeResp();
        BeanUtils.copyProperties(entity, resp);
        return resp;
    }

    @Override
    @Transactional
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    @Transactional
    public int batchDelete(List<Long> ids) {
        return mapper.deleteBatchIds(ids);
    }

    private LambdaQueryWrapper<Trade> req2QueryWrapper(TradeReq req) {
        LambdaQueryWrapper<Trade> wrapper = new LambdaQueryWrapper<>();
        if (req.getUpdateTime() != null) {
            wrapper.eq(Trade::getUpdateTime, req.getUpdateTime());
        }
        if (req.getCreateTime() != null) {
            wrapper.eq(Trade::getCreateTime, req.getCreateTime());
        }
        if (StringUtils.isNotBlank(req.getCreator())) {
            wrapper.eq(Trade::getCreator, req.getCreator());
        }
        if (StringUtils.isNotBlank(req.getUpdator())) {
            wrapper.eq(Trade::getUpdator, req.getUpdator());
        }
        if (req.getIsDelete() != null) {
            wrapper.eq(Trade::getIsDelete, req.getIsDelete());
        }
        if (req.getVersion() != null) {
            wrapper.eq(Trade::getVersion, req.getVersion());
        }
        wrapper.last(" order by update_time desc");
        return wrapper;
    }

    private Trade req2Entity(TradeReq req) {
        Trade entity = new Trade();
        BeanUtils.copyProperties(req, entity);
        return entity;
    }

    private TradeResp entity2Resp(Trade entity) {
        TradeResp resp = new TradeResp();
        BeanUtils.copyProperties(entity, resp);
        return resp;
    }
}
