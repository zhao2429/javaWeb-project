package com.project.dao;

import com.project.entity.Leave;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 10:59
 **/
public interface LeaveDao {
    //查询分页方法

    /**
     *
     * @param begin 这一页要显示的数据索引
     * @param pageSize 这一页需要显示几条
     * @return 返回查询的集合
     */
    List<Leave> selectByPage(int begin, int pageSize);
    //查询数据总数
    int selectByPageCount();
    //新增
    int insertLea(Leave leave);
}
