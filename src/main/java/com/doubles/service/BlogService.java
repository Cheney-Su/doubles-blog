package com.doubles.service;

import com.doubles.dao.BlogDao;
import com.doubles.entity.Blog;
import com.doubles.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
@Service
public class BlogService {

    @Autowired
    private BlogDao blogDao;

    public List<Blog> list(int page, int pageSize) {
        return blogDao.list(page, pageSize);
    }

    public Blog info(String blogId) {
        return blogDao.info(blogId);
    }

    public Result save(Blog params) {
        boolean flag = blogDao.save(params);
        if (flag)
            return new Result(0, "", "success");
        else
            return new Result(-1, "", "暂无数据");
    }

    public Result delete(String blogId) {
        boolean flag = blogDao.delete(blogId);
        if (flag)
            return new Result(0, "", "success");
        else
            return new Result(-1, "", "暂无数据");
    }
}
