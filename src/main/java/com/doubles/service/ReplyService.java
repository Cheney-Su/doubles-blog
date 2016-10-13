package com.doubles.service;

import com.doubles.dao.BlogClassDao;
import com.doubles.dao.ReplyDao;
import com.doubles.entity.BlogClass;
import com.doubles.entity.Reply;
import com.doubles.entity.Result;
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

    public Result add(Reply params) {
        boolean flag = replyDao.add(params);
        if (flag)
            return new Result(0, "", "success");
        else
            return new Result(-1, "", "系统异常");
    }
}
