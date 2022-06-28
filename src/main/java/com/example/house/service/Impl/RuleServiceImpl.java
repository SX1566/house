package com.example.house.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.dao.dos.House;
import com.example.house.dao.dos.Rule;
import com.example.house.dao.mapper.HouseMapper;
import com.example.house.dao.mapper.RuleMapper;
import com.example.house.entity.req.HouseReq;
import com.example.house.entity.req.RuleReq;
import com.example.house.entity.resp.HouseResp;
import com.example.house.entity.resp.RuleResp;
import com.example.house.service.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleMapper mapper;

    @Override
    public Page<RuleResp> page(RuleReq req) {
        Page<Rule> page = new Page<>(req.getPageNum(), req.getPageSize());
        Page<Rule> resp = mapper.selectPage(page, req2QueryWrapper(req));
        List<RuleResp> records = resp.getRecords().stream().map(this::entity2Resp).collect(Collectors.toList());
        return new Page<RuleResp>(resp.getCurrent(), resp.getSize(), resp.getTotal()).setRecords(records);
    }


    @Override
    @Transactional
    public int add(RuleReq req) {
        Rule rule = req2Entity(req);
        return mapper.insert(rule);
    }

    @Override
    @Transactional
    public int update(RuleReq req) {
        return mapper.updateById(req2Entity(req));
    }


    @Override
    public RuleResp queryById(Long id) {
        Rule entity = mapper.selectById(id);
        if (entity == null) {
            return null;
        }
        RuleResp resp = new RuleResp();
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

    private LambdaQueryWrapper<Rule> req2QueryWrapper(RuleReq req) {
        LambdaQueryWrapper<Rule> wrapper = new LambdaQueryWrapper<>();
        if (req.getUpdateTime() != null) {
            wrapper.eq(Rule::getUpdateTime, req.getUpdateTime());
        }
        if (req.getCreateTime() != null) {
            wrapper.eq(Rule::getCreateTime, req.getCreateTime());
        }
        if (StringUtils.isNotBlank(req.getCreator())) {
            wrapper.eq(Rule::getCreator, req.getCreator());
        }
        if (StringUtils.isNotBlank(req.getUpdator())) {
            wrapper.eq(Rule::getUpdator, req.getUpdator());
        }
        if (req.getIsDelete() != null) {
            wrapper.eq(Rule::getIsDelete, req.getIsDelete());
        }
        if (req.getVersion() != null) {
            wrapper.eq(Rule::getVersion, req.getVersion());
        }
        wrapper.last(" order by update_time desc");
        return wrapper;
    }

    private Rule req2Entity(RuleReq req) {
        Rule entity = new Rule();
        BeanUtils.copyProperties(req, entity);
        return entity;
    }

    private RuleResp entity2Resp(Rule entity) {
        RuleResp resp = new RuleResp();
        BeanUtils.copyProperties(entity, resp);
        return resp;
    }
}
