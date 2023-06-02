package com.project.dao;

import com.project.entity.Student;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/31 9:19
 **/
public interface StudentDao {
    /**
     * 增加
     * @param student 需要查询的条件
     * @return 返回受影响的行数
     */
    int insertStu(Student student);
    //删除
    int deleteStu(Student student);
    //修改
    int updateStu(Student student);
    //查询单个
    Student getById(Student student);
    //查询全部
    List<Student> getStuList();

    /**
     * 根据用户名查询的方法
     * @param student   查询的学生对象
     * @return 返回的信息
     */
    Student selectByName(Student student);

    //批量删除
    int deleteByIdS(int[] ids);

    //查询分页方法

    /**
     *
     * @param begin 这一页要显示的数据索引
     * @param pageSize 这一页需要显示几条
     * @return 返回查询的集合
     */
    List<Student> selectByPage(int begin,int pageSize);
    //查询数据总数
    int selectByPageCount();



    //带条件查询分页方法
    /**
     *
     * @param begin 这一页要显示的数据索引
     * @param pageSize 这一页需要显示几条
     * @return 返回查询的集合
     */
    List<Student> selectByPageIf(int begin,int pageSize,Student student);
    //带条件查询数据总数
    int selectByPageCountIf(Student student);
}
