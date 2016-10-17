package com.doubles.controller;

import com.doubles.entity.Blog;
import com.doubles.entity.Result;
import com.doubles.service.BlogService;
import com.doubles.utils.StringUtils;
import com.doubles.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
@RestController
@RequestMapping("blog")
public class BlogController {

    public static final String BLOGLIST = "/list/";
    public static final String BLOGINFO = "/list/{blogId}";
    public static final String SAVE = "/save";

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = {BLOGLIST}, method = RequestMethod.GET)
    public Result list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        List<Blog> list = blogService.list(page, pageSize);
        return new Result(0, list, "success");
    }

    @RequestMapping(value = {BLOGINFO})
    public Result info(@PathVariable String blogId) {
        if (StringUtils.isEmpty(blogId))
            return new Result(-1, "", "参数blogId不能为空");
        Blog blog = blogService.info(blogId);
        if (Utils.isEmpty(blog))
            return new Result(-1, "", "暂无数据");
        return new Result(0, blog, "success");
    }

    @RequestMapping(value = {SAVE}, method = RequestMethod.POST)
    public Result save(@RequestBody Blog params) {
        return new Result(0, "", "success");
    }
}
