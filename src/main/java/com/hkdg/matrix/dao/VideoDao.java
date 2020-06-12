package com.hkdg.matrix.dao;

import com.hkdg.matrix.bean.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * _._
 * _.-``__ ''-._
 * _.-``    `.  `_.  ''-._
 * .-`` .-```.  ```\/    _.,_ ''-._
 * (    '      ,       .-`  | `,    )
 * |`-._`-...-` __...-.``-._|'` _.-'|
 * |    `-._   `._    /     _.-'    |
 * `-._    `-._  `-./  _.-'    _.-'
 * |`-._`-._    `-.__.-'    _.-'_.-'|
 * |    `-._`-._        _.-'_.-'    |
 * `-._    `-._`-.__.-'_.-'    _.-'
 * |`-._`-._    `-.__.-'    _.-'_.-'|
 * |    `-._`-._        _.-'_.-'    |
 * `-._    `-._`-.__.-'_.-'    _.-'
 * `-._    `-.__.-'    _.-'
 * `-._        _.-'
 * `-.__.-'
 *
 * @Description
 * @Author tyx
 * @Date 2020/6/9
 */
public interface VideoDao extends JpaRepository<Video, Integer> {

    @Query("select v from Video v")
    List<Video> findAll();

    Video queryById(Integer id);
}















