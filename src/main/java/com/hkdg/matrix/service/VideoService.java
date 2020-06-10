package com.hkdg.matrix.service;

import com.hkdg.matrix.bean.Video;
import com.xxl.sso.core.entity.ReturnT;

import java.util.List;

/**
 * @Description
 * @Author tyx
 * @Date 2020/6/10
 */
public interface VideoService {
    public ReturnT<List<Video>> getVideoList();
}
