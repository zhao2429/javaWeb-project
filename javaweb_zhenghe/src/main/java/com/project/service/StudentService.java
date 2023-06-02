package com.project.service;

import com.project.entity.PageBean;
import com.project.entity.Student;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/31 9:35
 **/
public interface StudentService {
    boolean add(Student student);
    boolean remove(Student student);
    boolean modify(Student student);
    Student getById(Student student);
    List<Student> getAll();
    //登录的方法
    Student login(Student student);

    boolean removeByIds(int[] ids);

    //分页查询全部
    PageBean<Student> selectByPage(int currentPage, int pageSize);

    //条件分页
    PageBean<Student> selectByPageIf(int currentPage, int pageSize,Student student);
}
