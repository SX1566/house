package com.example.house.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.entity.req.HouseReq;
import com.example.house.entity.resp.HouseResp;
import com.example.house.mapper.HouseMapper;
import com.example.house.pojo.House;
import com.example.house.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper mapper;

    @Override
    public Page<HouseResp> page(HouseReq req) {
        Page<House> page = new Page<>(req.getPageNum(), req.getPageSize());
        Page<House> resp = mapper.selectPage(page, req2QueryWrapper(req));
        List<HouseResp> records = resp.getRecords().stream().map(this::entity2Resp).collect(Collectors.toList());
        return new Page<HouseResp>(resp.getCurrent(), resp.getSize(), resp.getTotal()).setRecords(records);
    }
    

    @Override
    @Transactional
    public int add(HouseReq req) {
        House house = req2Entity(req);
        return mapper.insert(house);
    }

    @Override
    @Transactional
    public int update(HouseReq req) {
        return mapper.updateById(req2Entity(req));
    }

    @Override
    public int audit(HouseReq req) {
        LambdaUpdateWrapper<House> wrapper = new LambdaUpdateWrapper<>();
        return mapper.update(req2Entity(req),wrapper
                .eq(House::getId,req.getId())
        );
    }

    @Override
    public HouseResp queryById(Long id) {
        House entity = mapper.selectById(id);
        if (entity == null) {
            return null;
        }
        HouseResp resp = new HouseResp();
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

    private LambdaQueryWrapper<House> req2QueryWrapper(HouseReq req) {
        LambdaQueryWrapper<House> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(req.getName())) {
            wrapper.eq(House::getName, req.getName());
        }
        if (StringUtils.isNotBlank(req.getAddress())) {
            wrapper.eq(House::getAddress, req.getAddress());
        }
        if (Double.isNaN(req.getPrice())) {
            wrapper.eq(House::getPrice, req.getPrice());
        }
        if (StringUtils.isNotBlank(req.getPhoto())) {
            wrapper.eq(House::getPhoto, req.getPhoto());
        }
        if (req.getStatus() != null) {
            wrapper.eq(House::getStatus, req.getStatus());
        }
        if (req.getService() != null) {
            wrapper.eq(House::getService, req.getService());
        }
        if (req.getHouseSize() != null) {
            wrapper.eq(House::getHouseSize, req.getHouseSize());
        }
        if (req.getPeopleNumber() != null) {
            wrapper.eq(House::getPeopleNumber, req.getPeopleNumber());
        }
        if (req.getBedNumber() != null) {
            wrapper.eq(House::getBedNumber, req.getBedNumber());
        }
        if (req.getToiletNumber() != null) {
            wrapper.eq(House::getToiletNumber, req.getToiletNumber());
        }
        if (req.getHostId() != null) {
            wrapper.eq(House::getHostId, req.getHostId());
        }
        if (req.getDescription() != null) {
            wrapper.eq(House::getDescription, req.getDescription());
        }
        if (req.getBedroomNumber() != null) {
            wrapper.eq(House::getBedroomNumber, req.getBedroomNumber());
        }
        if (req.getBedType() != null) {
            wrapper.eq(House::getBedType, req.getBedType());
        }
        if (req.getUpdateTime() != null) {
            wrapper.eq(House::getUpdateTime, req.getUpdateTime());
        }
        if (req.getCreateTime() != null) {
            wrapper.eq(House::getCreateTime, req.getCreateTime());
        }
        if (StringUtils.isNotBlank(req.getCreator())) {
            wrapper.eq(House::getCreator, req.getCreator());
        }
        if (StringUtils.isNotBlank(req.getUpdator())) {
            wrapper.eq(House::getUpdator, req.getUpdator());
        }
        if (req.getIsDelete() != null) {
            wrapper.eq(House::getIsDelete, req.getIsDelete());
        }
        if (req.getVersion() != null) {
            wrapper.eq(House::getVersion, req.getVersion());
        }
        wrapper.last(" order by update_time desc");
        return wrapper;
    }

    private House req2Entity(HouseReq req) {
        House entity = new House();
        BeanUtils.copyProperties(req, entity);
        return entity;
    }

    private HouseResp entity2Resp(House entity) {
        HouseResp resp = new HouseResp();
        BeanUtils.copyProperties(entity, resp);
        return resp;
    }
}
