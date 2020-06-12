package com.hkdg.matrix.service.impl;

import com.hkdg.matrix.bean.User;
import com.hkdg.matrix.dao.UserDao;
import com.hkdg.matrix.service.UserService;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.login.SsoTokenLoginHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ReturnT<User> findUserByEmailAndPassword(String email, String password) {

        if (email == null || email.trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input email.");
        }
        if (password == null || password.trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input password.");
        }

        User user = userDao.findByEmailAndPassword(email, password);

        if (user != null) {
            return new ReturnT<>(user);
        }

        return new ReturnT<>(ReturnT.FAIL_CODE, "密码错误!");
    }

    @Override
    public ReturnT<User> findUserBySessionId(String sessionId) {
        XxlSsoUser xxlUser = SsoTokenLoginHelper.loginCheck(sessionId);
        String userId = xxlUser.getUserid();
        User user = userDao.findById(Integer.parseInt(userId));
        user.setPassword(null);
        ReturnT<User> returnT = new ReturnT<>(user);
        return returnT;
    }

    @Override
    public ReturnT<Boolean> checkUserBySessionId(String sessionId) {
        XxlSsoUser xxlUser = SsoTokenLoginHelper.loginCheck(sessionId);
        return new ReturnT<>(xxlUser != null);
    }


    @Override
    public ReturnT<User> register(User user) {

        if (user.getEmail() == null || user.getEmail().trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input username.");
        }
        if (user.getPassword() == null || user.getPassword().trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input password.");
        }

        User u = userDao.findByEmail(user.getEmail());
        if (u != null)
            return new ReturnT<>(ReturnT.FAIL_CODE, "邮箱已被注册!");
        userDao.save(user);
        return new ReturnT<>(ReturnT.SUCCESS_CODE, "注册成功!");
    }


}
