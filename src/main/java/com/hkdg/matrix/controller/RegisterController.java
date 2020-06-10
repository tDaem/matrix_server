package com.hkdg.matrix.controller;

import com.hkdg.matrix.bean.User;
import com.hkdg.matrix.service.UserService;
import com.xxl.sso.core.entity.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户注册控制器
 * @Author tyx
 * @Date 2020/6/10
 */
@RestController
@RequestMapping("/app")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ReturnT register(User user) {
        return userService.register(user);
    }

}
