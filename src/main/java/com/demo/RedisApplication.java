package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: zengyz
 * @Date: 2022/3/10 14:26
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.demo"})
@MapperScan(basePackages = {"com.demo.redis.entity"})
public class RedisApplication {
    public static void main(String[] args) {
      SpringApplication.run(RedisApplication.class, args);
    }

}
