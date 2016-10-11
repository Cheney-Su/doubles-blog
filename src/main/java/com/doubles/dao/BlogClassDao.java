package com.doubles.dao;

import com.doubles.entity.BlogClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
@Component
public class BlogClassDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BlogClass> list() {
        List<BlogClass> list = new ArrayList<BlogClass>();
        String sql = "select * from tb_blogclass t order by t.createTime desc";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        while (rs != null && rs.next()) {
            BlogClass entity = new BlogClass();
            entity.setId(rs.getInt("id"));
            entity.setClassName(rs.getString("className").toString());
            entity.setCreateTime(rs.getString("createTime").toString());
            list.add(entity);
        }
        return list;
    }
}
