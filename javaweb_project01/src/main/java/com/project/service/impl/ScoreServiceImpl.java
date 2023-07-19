package com.project.service.impl;

import com.project.dao.ScoreDao;
import com.project.dao.impl.ScoreDaoImpl;
import com.project.entity.PageBean;
import com.project.entity.Score;
import com.project.service.ScoreService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 15:38
 **/
public class ScoreServiceImpl implements ScoreService {
    private ScoreDao scoreDao = new ScoreDaoImpl();
    @Override
    public boolean add(Score score) {
        return scoreDao.insertSco(score) > 0;
    }

    @Override
    public PageBean<Score> selectByPage(int currentPage, int pageSize) {
        //求出分页的开始索引
        int begin = (currentPage-1)*pageSize;
        //查询分页数据
        List<Score> scoreList = scoreDao.selectByPage(begin, pageSize);
        //分页的count
        int count = scoreDao.selectByPageCount();
        PageBean<Score> scorePageBean = new PageBean<>(scoreList,count);
        return scorePageBean;
    }
}
