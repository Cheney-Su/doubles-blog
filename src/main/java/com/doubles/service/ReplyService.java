package com.doubles.service;

import com.doubles.dao.BlogClassDao;
import com.doubles.dao.ReplyDao;
import com.doubles.entity.BlogClass;
import com.doubles.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
@Service
public class ReplyService {

    @Autowired
    private ReplyDao replyDao;

    public List<Reply> replyListByBlogId(String blogId) {
        return replyDao.replyListByBlogId(blogId);
    }
}
