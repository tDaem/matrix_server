package com.hkdg.matrix.controller;

import com.hkdg.matrix.bean.Video;
import com.hkdg.matrix.service.VideoService;
import com.xxl.sso.core.entity.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 获取视频信息
 * @Author tyx
 * @Date 2020/6/9
 */
@RestController
@RequestMapping("/app")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/videolist")
    public ReturnT<List<Video>> getVideoList() {
        return videoService.getVideoList();
    }

    @GetMapping("/video")
    public ReturnT<Video> getVideo(Integer id) {
        return videoService.getVideoById(id);
    }

}
