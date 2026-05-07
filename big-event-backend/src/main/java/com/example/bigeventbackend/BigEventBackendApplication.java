package com.example.bigeventbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bigeventbackend.mapper") // 加上这行
public class BigEventBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BigEventBackendApplication.class, args);
    }
}