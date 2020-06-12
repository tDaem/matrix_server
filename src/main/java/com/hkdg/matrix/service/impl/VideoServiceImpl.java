package com.hkdg.matrix.service.impl;

import com.hkdg.matrix.bean.Video;
import com.hkdg.matrix.dao.VideoDao;
import com.hkdg.matrix.service.VideoService;
import com.xxl.sso.core.entity.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public ReturnT<List<Video>> getVideoList() {
        List<Video> videos = videoDao.findAll();
        /*for (int i = 0; i < videos.size(); i++) {
            videos.get(i).setVideoUrl(null);
        }*/
        ReturnT<List<Video>> returnT = new ReturnT<>(videos);
        return returnT;
    }

    @Override
    public ReturnT<Video> getVideoById(Integer id) {
        Video video = videoDao.queryById(id);
        ReturnT<Video> returnT = new ReturnT<>(video);
        return returnT;
    }
}
