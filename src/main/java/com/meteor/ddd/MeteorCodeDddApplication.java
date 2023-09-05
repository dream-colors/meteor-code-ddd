package com.meteor.ddd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.meteor.ddd.infrastructure.repository.mapper"})
public class MeteorCodeDddApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeteorCodeDddApplication.class, args);
    }

}
