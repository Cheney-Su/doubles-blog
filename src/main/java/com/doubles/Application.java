package com.doubles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2016/7/12.
 * USER: Suhuaqiang
 */
@Configuration//配置控制
@EnableAutoConfiguration//启用自动配置
@ComponentScan(basePackages={"com.doubles.controller","com.doubles.dao","com.doubles.service","com.doubles.config","com.doubles.redis"})//组件扫描
@ServletComponentScan
//@SpringBootApplication //等价于上面三个
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        //启动Spring Boot项目的唯一入口
        SpringApplication.run(Application.class, args);
    }

}
