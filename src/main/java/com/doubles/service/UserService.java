package com.doubles.service;

import com.doubles.dao.BlogDao;
import com.doubles.dao.UserDao;
import com.doubles.entity.Blog;
import com.doubles.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User user(User params) {
        return userDao.user(params);
    }
}
