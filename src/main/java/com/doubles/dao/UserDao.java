package com.doubles.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * UserLoginDao用户登陆dao层
 * Created by Administrator on 2016/7/12.
 * USER: Suhuaqiang
 */
@Repository()
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

}
