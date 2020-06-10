package com.hkdg.matrix.service;


import com.hkdg.matrix.bean.User;
import com.xxl.sso.core.entity.ReturnT;

public interface UserService {

    /**
     * 通过邮箱和密码找用户
     * @param email
     * @param password
     * @return
     */
    ReturnT<User> findUser(String email, String password);

    /**
     * 通过sessionId找用户
     * @param sessionId
     * @return
     */
    ReturnT<User> findUser(String sessionId);
}
