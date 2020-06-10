package com.hkdg.matrix.dao;


import com.hkdg.matrix.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author tyx
 * @Date 2020/6/9
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

    User findById(int id);

    User findByEmail(String email);

}
