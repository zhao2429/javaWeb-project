package com.project.dao;

import com.project.entity.Score;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 15:31
 **/
public interface ScoreDao {
//    新增
    int insertSco(Score score);
    //查询分页方法

    /**
     *
     * @param begin 这一页要显示的数据索引
     * @param pageSize 这一页需要显示几条
     * @return 返回查询的集合
     */
    List<Score> selectByPage(int begin, int pageSize);
    //查询数据总数
    int selectByPageCount();
}
