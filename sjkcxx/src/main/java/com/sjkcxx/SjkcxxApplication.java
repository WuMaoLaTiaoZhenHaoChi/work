package com.sjkcxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.sjkcxx.mapper")
public class SjkcxxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjkcxxApplication.class, args);
    }

}
