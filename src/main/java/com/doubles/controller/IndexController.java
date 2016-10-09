package com.doubles.controller;

import com.doubles.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/10/9.
 */
@RestController
@RequestMapping("blog")
public class IndexController {

    @RequestMapping(value = "/")
    public Result index() {
        return new Result(0, "", "成功");
    }
}
