package com.doubles.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 配置jdbc数据源,数据源参数在application.yml中配置
 * Created by Administrator on 2016/7/12.
 * USER: Suhuaqiang
 */
@Configuration
public class DBConfig {

    @Bean(name = "dataSource")
    @Qualifier("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.doubles_blog")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(
            @Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
