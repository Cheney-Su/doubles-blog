package com.doubles.controller;

import com.doubles.entity.BlogClass;
import com.doubles.entity.Result;
import com.doubles.service.BlogClassService;
import com.doubles.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
@RestController
@RequestMapping("blogClass")
public class BlogClassController {

    public static final String BLOGLIST = "/list/";

    @Autowired
    private BlogClassService blogClassService;

    @RequestMapping(value = {BLOGLIST}, method = RequestMethod.GET)
    public Result list() {
        List<BlogClass> list = blogClassService.list();
        return new Result(0, list, "success");
    }
}
