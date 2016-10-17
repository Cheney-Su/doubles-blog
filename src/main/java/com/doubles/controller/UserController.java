package com.doubles.controller;

import com.doubles.entity.Blog;
import com.doubles.entity.Result;
import com.doubles.entity.User;
import com.doubles.service.BlogService;
import com.doubles.service.UserService;
import com.doubles.utils.StringUtils;
import com.doubles.utils.Utils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */
@RestController
@RequestMapping("manager")
public class UserController {

    public static final String USER = "/user";

    @Autowired
    private UserService userService;

    @RequestMapping(value = {USER}, method = RequestMethod.POST)
    public Result user(@RequestBody User params) {
        System.out.println(new Gson().toJson(params));
        if (StringUtils.isEmpty(params.getUserName()) || StringUtils.isEmpty(params.getPassword())) {
            return new Result(-1, "", "用户名或密码不能为空");
        }
        User user = userService.user(params);
        if (user == null) {
            return new Result(-1, "", "暂无数据，请联系管理员");
        }
        return new Result(0, "", "success");
    }
}
