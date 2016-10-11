package com.doubles.dao;

import com.doubles.entity.Blog;
import com.doubles.utils.HtmlUtils;
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
public class BlogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Blog> list(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = pageSize;
        List<Blog> list = new ArrayList<Blog>();
        String sql = "select * from tb_blog t order by t.createTime desc limit ?,?";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, new Object[]{start, end});
        while (rs != null && rs.next()) {
            Blog entity = new Blog();
            entity.setId(rs.getInt("id"));
            entity.setAuthor(rs.getString("author").toString());
            entity.setCreateTime(rs.getString("createTime").toString());
            entity.setReadCount(rs.getInt("readCount"));
            entity.setTitle(rs.getString("title").toString());
            entity.setBlogType(rs.getString("blogType").toString());
            entity.setContent(rs.getString("content").toString());
            entity.setAbstracts(rs.getString("abstracts").toString());
            entity.setBlogClassName(rs.getString("blogClassName").toString());
            entity.setBlogClassId(rs.getInt("blogClassId"));
            entity.setKeyWords(rs.getString("keyWords").toString());
            list.add(entity);
        }
        return list;
    }

    public Blog info(String id) {
        Blog entity = null;
        String sql = "select * from tb_blog t where t.id = ? limit 1";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, new Object[]{id});
        if (rs.next()) {
            entity = new Blog();
            entity.setId(rs.getInt("id"));
            entity.setAuthor(rs.getString("author").toString());
            entity.setCreateTime(rs.getString("createTime").toString());
            entity.setReadCount(rs.getInt("readCount"));
            entity.setTitle(rs.getString("title").toString());
            entity.setBlogType(rs.getString("blogType").toString());
            entity.setContent(rs.getString("content").toString());
            entity.setAbstracts(rs.getString("abstracts").toString());
            entity.setBlogClassName(rs.getString("blogClassName").toString());
            entity.setBlogClassId(rs.getInt("blogClassId"));
            entity.setKeyWords(rs.getString("keyWords").toString());
        }
        return entity;
    }
}
