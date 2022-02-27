package com.quan.forumproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.quan.forumproject.mapper")
public class ForumProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumProjectApplication.class, args);
    }

}
