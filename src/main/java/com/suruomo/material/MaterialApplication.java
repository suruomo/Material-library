package com.suruomo.material;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author 苏若墨
 */
@SpringBootApplication
@MapperScan("com.suruomo.material.dao")
public class MaterialApplication{

    public static void main(String[] args) {
        SpringApplication.run(MaterialApplication.class, args);
    }
}
