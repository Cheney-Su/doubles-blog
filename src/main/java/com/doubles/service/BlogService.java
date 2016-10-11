package com.doubles.service;

import com.doubles.dao.BlogDao;
import com.doubles.entity.Blog;
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

    public Blog info(String id) {
        return blogDao.info(id);
    }
}
