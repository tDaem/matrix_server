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
     * 通过id找用户
     * @param id
     * @return
     */
    ReturnT<User> findUser(int id);
}
