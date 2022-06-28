package com.example.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.example.house.dao.mapper")
@ComponentScan(basePackages = "com.example.house.service")
@SpringBootApplication(scanBasePackages = "com.example.house")
public class HouseApplication {

    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(HouseApplication.class, args);
    }

}
