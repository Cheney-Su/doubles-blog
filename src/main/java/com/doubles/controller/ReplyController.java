package com.doubles.controller;

import com.doubles.entity.BlogClass;
import com.doubles.entity.Reply;
import com.doubles.entity.Result;
import com.doubles.service.BlogClassService;
import com.doubles.service.ReplyService;
import com.doubles.utils.StringUtils;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
@RestController
@RequestMapping("reply")
public class ReplyController {

    public static final String REPLYBLOGID = "/{blogId}";
    public static final String ADDREPLY = "/add";

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = {REPLYBLOGID})
    public Result replyListByBlogId(@PathVariable String blogId) {
        if (StringUtils.isEmpty(blogId))
            return new Result(-1, "", "参数blogId不能为空");
        List<Reply> list = replyService.replyListByBlogId(blogId);
        return new Result(0, list, "success");
    }

    @RequestMapping(value = {ADDREPLY}, method = RequestMethod.POST)
    public Result addReply(@RequestBody Reply params) {
//        System.out.println(new Gson().toJson(params));
        if (0 == params.getBlogId() || StringUtils.isEmpty(params.getContent())
                || 0 == params.getOwnerId() || 0 == params.getToUserId())
            return new Result(-1, "", "参数不正确");

        return replyService.add(params);
    }
}
