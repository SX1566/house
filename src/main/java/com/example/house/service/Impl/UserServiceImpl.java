package com.example.house.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.entity.req.UserReq;
import com.example.house.entity.resp.UserResp;
import com.example.house.mapper.UserMapper;
import com.example.house.pojo.User;
import com.example.house.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public Page<UserResp> page(UserReq req) {
        Page<User> page = new Page<>(req.getPageNum(), req.getPageSize());
        Page<User> resp = mapper.selectPage(page, req2QueryWrapper(req));
        List<UserResp> records = resp.getRecords().stream().map(this::entity2Resp).collect(Collectors.toList());
        return new Page<UserResp>(resp.getCurrent(), resp.getSize(), resp.getTotal()).setRecords(records);
    }


    @Override
    @Transactional
    public int add(UserReq req) {
        User user = req2Entity(req);
        return mapper.insert(user);
    }

    @Override
    @Transactional
    public int update(UserReq req) {
        return mapper.updateById(req2Entity(req));
    }


    @Override
    public UserResp queryById(Long id) {
        User entity = mapper.selectById(id);
        if (entity == null) {
            return null;
        }
        UserResp resp = new UserResp();
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

    private LambdaQueryWrapper<User> req2QueryWrapper(UserReq req) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (req.getUpdateTime() != null) {
            wrapper.eq(User::getUpdateTime, req.getUpdateTime());
        }
        if (req.getCreateTime() != null) {
            wrapper.eq(User::getCreateTime, req.getCreateTime());
        }
        if (StringUtils.isNotBlank(req.getCreator())) {
            wrapper.eq(User::getCreator, req.getCreator());
        }
        if (StringUtils.isNotBlank(req.getUpdator())) {
            wrapper.eq(User::getUpdator, req.getUpdator());
        }
        if (req.getIsDelete() != null) {
            wrapper.eq(User::getIsDelete, req.getIsDelete());
        }
        if (req.getVersion() != null) {
            wrapper.eq(User::getVersion, req.getVersion());
        }
        wrapper.last(" order by update_time desc");
        return wrapper;
    }

    private User req2Entity(UserReq req) {
        User entity = new User();
        BeanUtils.copyProperties(req, entity);
        return entity;
    }

    private UserResp entity2Resp(User entity) {
        UserResp resp = new UserResp();
        BeanUtils.copyProperties(entity, resp);
        return resp;
    }
}
