package com.example.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HouseApplication {

    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(HouseApplication.class, args);
    }

}
