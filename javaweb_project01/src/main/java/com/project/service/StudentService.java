package com.project.service;

import com.project.entity.PageBean;
import com.project.entity.Student;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 16:30
 **/
public interface StudentService {
    boolean add(Student student);
    boolean remove(Student student);
    boolean modify(Student student);
    Student getById(Student student);
    //查询全部的方法
    List<Student> getAll();
    //登录
    Student login(Student student);
    //批量删除
    boolean removeIds(int[] ids);

    //带条件分页查询
    PageBean<Student> selectByPageIf(int currentPage, int pageSize, Student student);

}
