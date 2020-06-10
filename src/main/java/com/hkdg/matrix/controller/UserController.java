package com.hkdg.matrix.controller;

import com.hkdg.matrix.bean.User;
import com.hkdg.matrix.service.UserService;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.login.SsoTokenLoginHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户信息控制器
 * @Author tyx
 * @Date 2020/6/10
 */
@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     *
     * @param sessionId
     * @return
     */
    @GetMapping("/userInfo")
    public ReturnT<User> userInfo(String sessionId) {
        XxlSsoUser xxlUser = SsoTokenLoginHelper.loginCheck(sessionId);
        return userService.findUser(Integer.parseInt(xxlUser.getUserid()));
    }


}
