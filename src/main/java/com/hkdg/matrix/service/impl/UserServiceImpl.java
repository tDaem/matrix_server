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
    public ReturnT<User> findUser(String email, String password) {

        if (email == null || email.trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input username.");
        }
        if (password == null || password.trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input password.");
        }

        User user = userDao.findByEmailAndPassword(email, password);

        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return new ReturnT<>(user);
        }

        return new ReturnT<>(ReturnT.FAIL_CODE, "密码错误!");
    }

    @Override
    public ReturnT<User> findUser(String sessionId) {
        XxlSsoUser xxlUser = SsoTokenLoginHelper.loginCheck(sessionId);
        String userId = xxlUser.getUserid();
        User user = userDao.findById(Integer.parseInt(userId));
        ReturnT<User> returnT = new ReturnT<>(user);
        return returnT;
    }


}
