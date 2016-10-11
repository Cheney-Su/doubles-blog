package com.doubles.service;

import com.doubles.dao.BlogClassDao;
import com.doubles.entity.BlogClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
@Service
public class BlogClassService {

    @Autowired
    private BlogClassDao blogClassDao;

    public List<BlogClass> list() {
        return blogClassDao.list();
    }
}
