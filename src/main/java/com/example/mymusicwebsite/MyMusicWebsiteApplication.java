package com.example.mymusicwebsite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Hot update and hot reload:
1. Ctrl + Shift + A --> search Registry..., find the one with 3 dots.
   Then find compiler.automake.allow.when.running, select it.
2. Ctrl + F9 for hot reload
 */

@SpringBootApplication
@MapperScan("com.example.mymusicwebsite.dao")
public class MyMusicWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMusicWebsiteApplication.class, args);
    }

}
