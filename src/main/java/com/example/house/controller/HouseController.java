package com.example.house.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {


    @GetMapping(value = "/CarsTrainList")
    @ApiOperation("车型库分页查询")
    public BaseResult<Page<CarsTrainDTO>> pageQuery(@RequestBody CarsTrainQuery query){
        return carsTrainServiceApi.pageQuery(query);
    }

    @GetMapping(value = "/CarsTrainCombox")
    @ApiOperation("车型库下拉框")
    public BaseResult<List<BrandSeriesModelComboBoxDTO>> carsTrainCombox(@RequestBody BrandSeriesModelComboBoxQuery query){
        return carsTrainServiceApi.carsTrainCombox(query);
    }

    @PostMapping(value = "/CarsTrainAddOrEdit")
    @ApiOperation("车型库新增 or 修改")
    public BaseResult<Boolean> updateOrCreateMotorcycleType(@RequestBody MotorcycleTypeParamQuery query){
        query.setOperatorId(userDTO.getUserId());
        query.setClientChannel(userDTO.getChannel());
        query.setOperatorName(userDTO.getUserName());
        return carsTrainServiceApi.updateOrCreateMotorcycleType(query);
    }
}
