package com.doubles.dao;

import com.doubles.entity.Blog;
import com.doubles.entity.BlogClass;
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

    public List<Blog> blogListFromClassId(String blogClassId) {
        List<Blog> list = new ArrayList<Blog>();
        String sql = "select t1.* from tb_blogclass t,tb_blog t1 where t.id = ? and t.id = t1.blogClassId";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, new Object[]{blogClassId});
        while (rs != null && rs.next()) {
            Blog entity = new Blog();
            entity.setId(rs.getInt("id"));
            entity.setUserId(rs.getInt("userId"));
            entity.setAuthor(rs.getString("author").toString());
            entity.setCreateTime(rs.getString("createTime").toString());
            entity.setReadCount(rs.getInt("readCount"));
            entity.setTitle(rs.getString("title").toString());
            entity.setBlogType(rs.getString("blogType").toString());
            entity.setContent(HtmlUtils.clean(400 > rs.getString("content").toString().length() ? rs.getString("content").toString() : rs.getString("content").toString().substring(0, 400)));
            entity.setAbstracts(rs.getString("abstracts").toString());
            entity.setBlogClassName(rs.getString("blogClassName").toString());
            entity.setBlogClassId(rs.getInt("blogClassId"));
            entity.setKeyWords(rs.getString("keyWords").toString());
            list.add(entity);
        }
        return list;
    }
}
