package com.hkdg.matrix.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @Description
 * @Author tyx
 * @Date 2020/6/9
 */
@Entity
@Table
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String email;

    private String password;

    private String avatarUrl;

    /**
     * 用户收藏的视频
     */
    @ManyToMany(targetEntity = Video.class)
    private List<Video> videos;

}
