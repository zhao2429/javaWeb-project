package com.project.dao;

import com.project.entity.Student;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/3 14:52
 **/
public interface StudentDao {
    /**
     * 登录
     * @param student
     * @return
     */
    Student selectByUserAndPassWord(Student student);

    /**
     * 查询用户名是否存在
     * @param student
     * @return
     */
    Student selectByName(Student student);

    //新增
    int insertStu(Student student);
    //删除
    int deleteStu(Student student);
    //修改
    int updateStu(Student student);
    //查询单个
    Student getById(Student student);
    //查询全部
    List<Student> getStuList();

    //批量删除
    int deleteByIds(int[] ids);

    //带条件分页查询

    /**
     *
     * @param begin 这一页的索引
     * @param pageSize 需要显示的页数
     * @param student 模糊查询的条件
     * @return
     */
    List<Student> selectByPageIf(int begin,int pageSize,Student student);
    //带条件查询数据总数
    int selectByPageCountIf(Student student);

}
