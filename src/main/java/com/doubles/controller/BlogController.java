package com.doubles.controller;

import com.doubles.entity.Blog;
import com.doubles.entity.Result;
import com.doubles.service.BlogService;
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

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = {BLOGLIST}, method = RequestMethod.GET)
    public Result list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "1") int pageSize) {
        List<Blog> list = blogService.list(page, pageSize);
        return new Result(0, list, "success");
    }
}
