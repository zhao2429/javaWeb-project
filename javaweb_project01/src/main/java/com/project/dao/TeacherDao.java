package com.project.dao;

import com.project.entity.Teacher;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 10:37
 **/
public interface TeacherDao {
    //登录
    Teacher selectByNameAndPassword(Teacher teacher);
    //查询用户名
    Teacher selectByName(Teacher teacher);

    //新增
    int insertTea(Teacher teacher);
    //删除
    int deleteTea(Teacher teacher);
    //修改
    int updateTea(Teacher teacher);
    //查询单个
    Teacher getById(Teacher teacher);
    //查询全部
    List<Teacher> getTeaList();
    //批量删除
    int deleteByIds(int[] ids);

    //带条件的分页查询

    /**
     *
     * @param begin 这一页的索引
     * @param pageSize 需要显示的页数
     * @param teacher 查询的对象
     * @return
     */
    List<Teacher> selectByPageIf(int begin,int pageSize,Teacher teacher);
    //分页总数
    int selectByPageCountIf(Teacher teacher);
}
