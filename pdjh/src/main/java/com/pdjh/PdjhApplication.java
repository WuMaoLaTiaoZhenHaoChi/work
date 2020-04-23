package com.pdjh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.pdjh.mapper")
public class PdjhApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdjhApplication.class, args);
    }

}
