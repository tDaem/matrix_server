package com.hkdg.matrix.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
@Entity
@Table
@Getter
@Setter
public class Video {

    @Id
    @GeneratedValue
    private int id;

    private String videoUrl;

    private String thumbnailUrl;
}
