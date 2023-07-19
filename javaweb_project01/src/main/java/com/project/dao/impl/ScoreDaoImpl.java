package com.project.dao.impl;

import com.project.dao.ScoreDao;
import com.project.entity.Score;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 15:32
 **/
public class ScoreDaoImpl extends BaseDao implements ScoreDao {
    @Override
    public int insertSco(Score score) {
        String sql = "insert into score values(?,?,?,?,?)";
        return update(sql,0,score.getUsername(),score.getGrade(),score.getProjectname(),score.getFraction());
    }

    @Override
    public List<Score> selectByPage(int begin, int pageSize) {
        String sql = "select * from score limit ?,?";
        return selectForList(Score.class,sql,begin,pageSize);
    }

    @Override
    public int selectByPageCount() {
        String sql = "select count(1) from score";
        Number number = (Number) selectForValue(sql);
        return number.intValue();
    }
}
