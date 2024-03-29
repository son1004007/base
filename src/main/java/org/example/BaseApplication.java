package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.example.mapper")
public class BaseApplication {
    public static void main(String[] args) {

        SpringApplication.run(BaseApplication.class, args);
    }
}