package com.doubles.controller;

import com.doubles.entity.Blog;
import com.doubles.entity.Result;
import com.doubles.service.BlogService;
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
    public static final String BLOGINFO = "/list/{id}";

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = {BLOGLIST}, method = RequestMethod.GET)
    public Result list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        List<Blog> list = blogService.list(page, pageSize);
        return new Result(0, list, "success");
    }

    @RequestMapping(value = {BLOGINFO})
    public Result info(@PathVariable String id) {
        Blog blog = blogService.info(id);
        if (Utils.isEmpty(blog))
            return new Result(0, "", "未查询到数据");
        return new Result(0, blog, "success");
    }

}
