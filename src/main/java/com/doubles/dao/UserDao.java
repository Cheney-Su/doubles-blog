package com.doubles.dao;

import com.doubles.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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

    public User user(User params) {
        User entity = null;
        String sql = "select * from tb_user t where t.userName = ? and t.passwd = ?";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, new Object[]{params.getUserName(), params.getPassword()});
        while (rs != null && rs.next()) {
            entity = new User();
            entity.setId(rs.getInt("id"));
            entity.setUserName(rs.getString("userName").toString());
            entity.setPassword(rs.getString("passwd").toString());
            entity.setNickName(rs.getString("nickName").toString());
            entity.setUserType(rs.getInt("userType"));
            entity.setSex(rs.getString("sex").toString());
            entity.setImg(rs.getString("img").toString());
            entity.setOpenId(rs.getString("openId").toString());
            entity.setCreateTime(rs.getString("createTime").toString());
        }
        return entity;
    }
}
