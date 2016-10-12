package com.doubles.controller;

import com.doubles.entity.BlogClass;
import com.doubles.entity.Reply;
import com.doubles.entity.Result;
import com.doubles.service.BlogClassService;
import com.doubles.service.ReplyService;
import com.doubles.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
@RestController
@RequestMapping("reply")
public class ReplyController {

    public static final String REPLYBLOGID = "/{blogId}";

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = {REPLYBLOGID})
    public Result replyListByBlogId(@PathVariable String blogId) {
        if (StringUtils.isEmpty(blogId))
            return new Result(-1, "", "参数blogId不能为空");
        List<Reply> list = replyService.replyListByBlogId(blogId);
        return new Result(0, list, "success");
    }
}
