package com.doubles.controller;

import com.doubles.entity.Blog;
import com.doubles.entity.BlogClass;
import com.doubles.entity.Result;
import com.doubles.service.BlogClassService;
import com.doubles.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
@RestController
@RequestMapping("blogClass")
public class BlogClassController {

    public static final String BLOGCLASSLIST = "/list/";
    public static final String BLOGLISTFROMCLASSID = "/list/{blogClassId}";

    @Autowired
    private BlogClassService blogClassService;

    @RequestMapping(value = {BLOGCLASSLIST}, method = RequestMethod.GET)
    public Result list() {
        List<BlogClass> list = blogClassService.list();
        return new Result(0, list, "success");
    }

    @RequestMapping(value = BLOGLISTFROMCLASSID)
    public Result blogListFromClassId(@PathVariable String blogClassId) {
        List<Blog> list = blogClassService.blogListFromClassId(blogClassId);
        if (list.size() > 0)
            return new Result(0, list, "success");
        else
            return new Result(-1, "", "暂无数据");
    }
}
