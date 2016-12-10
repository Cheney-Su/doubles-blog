package com.doubles.dao;

import com.doubles.entity.Blog;
import com.doubles.utils.Constant;
import com.doubles.utils.HtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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

    public Blog info(String blogId) {
        Blog entity = null;
        String sql = "select * from tb_blog t where t.id = ? limit 1";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, new Object[]{blogId});
        if (rs.next()) {
            entity = new Blog();
            entity.setId(rs.getInt("id"));
            entity.setUserId(rs.getInt("userId"));
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

    public boolean save(Blog params) {
        boolean flag = false;
        String currentTime = Constant.SDFDATE.format(new Date());
        String sql = "insert into tb_blog values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int rs = jdbcTemplate.update(sql, new Object[]{params.getId(), params.getUserId(), params.getAuthor(), currentTime, params.getReadCount(), params.getTitle(),
                params.getBlogType(), params.getContent(), params.getAbstracts(), params.getBlogClassName(), params.getBlogClassId(), params.getKeyWords()});
        if (rs > 0)
            flag = true;
        return flag;
    }

    public boolean delete(String blogId) {
        boolean flag = false;
        String sql = "delete from tb_blog where id = " + blogId;
        String sql2 = "delete from tb_reply where blogId = " + blogId;
        int[] rs = jdbcTemplate.batchUpdate(sql, sql2);
        if (rs[0] > 0)
            flag = true;
        return flag;
    }
}
