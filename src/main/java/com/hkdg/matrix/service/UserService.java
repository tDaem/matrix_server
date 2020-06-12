package com.hkdg.matrix.service;


import com.hkdg.matrix.bean.User;
import com.xxl.sso.core.entity.ReturnT;

public interface UserService {

    /**
     * 通过邮箱和密码找用户
     *
     * @param email
     * @param password
     * @return
     */
    ReturnT<User> findUserByEmailAndPassword(String email, String password);

    /**
     * 通过sessionId找用户
     *
     * @param sessionId
     * @return
     */
    ReturnT<User> findUserBySessionId(String sessionId);

    /**
     * 查询用户是否登录
     *
     * @param sessionId
     * @return
     */
    ReturnT<Boolean> checkUserBySessionId(String sessionId);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    ReturnT<User> register(User user);
}
