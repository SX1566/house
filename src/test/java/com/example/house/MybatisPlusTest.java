package com.example.house;

import com.example.house.mapper.HouseMapper;
import com.example.house.pojo.House;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {
    
    @Autowired
    HouseMapper houseMapper;
    
    @Test
    public void test(){
        List<House> houseList = houseMapper.selectList(null);
        houseList.forEach(System.out::println);
    }
}
