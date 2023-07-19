package com.project.service;

import com.project.entity.PageBean;
import com.project.entity.Score;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 15:36
 **/
public interface ScoreService {

    boolean add(Score score);
    PageBean<Score> selectByPage(int currentPage, int pageSize);
}
