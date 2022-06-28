package com.example.house.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.house.dao.AdminMapper;
import com.example.house.entity.req.AdminReq;
import com.example.house.entity.resp.AdminResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AdminServiceImpl {

    @Autowired
    private AdminMapper mapper;

    @Override
    public Page<AdminResp> page(AdminReq req) {
        Page<PatrolRecord> page = new Page<>(req.getPageNum(), req.getPageSize());
        Page<PatrolRecord> resp = mapper.selectPage(page, req2QueryWrapper(req));
        List<PatrolRecordResp> records = resp.getRecords().stream().map(this::entity2Resp).collect(Collectors.toList());
        return new Page<PatrolRecordResp>(resp.getCurrent(), resp.getSize(), resp.getTotal()).setRecords(records);
    }
    

    @Override
    @Transactional
    public int add(AdminReq req) {
        PatrolRecord patrolRecord = req2Entity(req);
        patrolRecord.setSnapshotTime(new Date());
        return mapper.insert(patrolRecord);
    }

    @Override
    @Transactional
    public int update(PatrolRecordReq req) {
        return mapper.updateById(req2Entity(req));
    }

    @Override
    public PatrolRecordResp queryById(Long id) {
        PatrolRecord entity = mapper.selectById(id);
        if (entity == null) {
            return null;
        }
        PatrolRecordResp resp = new PatrolRecordResp();
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

    private LambdaQueryWrapper<PatrolRecord> req2QueryWrapper(PatrolRecordQueryReq req) {
        LambdaQueryWrapper<PatrolRecord> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(req.getStoreId())) {
            wrapper.eq(PatrolRecord::getStoreId, req.getStoreId());
        }
        if (StringUtils.isNotBlank(req.getEquipmentCode())) {
            wrapper.eq(PatrolRecord::getEquipmentCode, req.getEquipmentCode());
        }
        if (StringUtils.isNotBlank(req.getDeviceName())) {
            wrapper.eq(PatrolRecord::getDeviceName, req.getDeviceName());
        }
        if (StringUtils.isNotBlank(req.getImageUrl())) {
            wrapper.eq(PatrolRecord::getImageUrl, req.getImageUrl());
        }
        if (StringUtils.isNotBlank(req.getDescription())) {
            wrapper.eq(PatrolRecord::getDescription, req.getDescription());
        }
        if (req.getSnapshotTime() != null) {
            wrapper.eq(PatrolRecord::getSnapshotTime, req.getSnapshotTime());
        }
        if (req.getCreateTime() != null) {
            wrapper.eq(PatrolRecord::getCreateTime, req.getCreateTime());
        }
        if (req.getUpdateTime() != null) {
            wrapper.eq(PatrolRecord::getUpdateTime, req.getUpdateTime());
        }
        if (StringUtils.isNotBlank(req.getCreator())) {
            wrapper.eq(PatrolRecord::getCreator, req.getCreator());
        }
        if (StringUtils.isNotBlank(req.getUpdator())) {
            wrapper.eq(PatrolRecord::getUpdator, req.getUpdator());
        }
        if (req.getIsDelete() != null) {
            wrapper.eq(PatrolRecord::getIsDelete, req.getIsDelete());
        }
        if (req.getVersion() != null) {
            wrapper.eq(PatrolRecord::getVersion, req.getVersion());
        }
        if (req.getUpdateTime() != null) {
            wrapper.orderByDesc(PatrolRecord::getUpdateTime);
        }
        wrapper.last(" order by update_time desc");
        return wrapper;
    }

    private PatrolRecord req2Entity(PatrolRecordReq req) {
        PatrolRecord entity = new PatrolRecord();
        BeanUtils.copyProperties(req, entity);
        return entity;
    }

    private PatrolRecordResp entity2Resp(PatrolRecord entity) {
        PatrolRecordResp resp = new PatrolRecordResp();
        BeanUtils.copyProperties(entity, resp);
        return resp;
    }
}
