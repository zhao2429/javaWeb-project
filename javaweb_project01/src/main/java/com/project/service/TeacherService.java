package com.project.service;

import com.project.entity.PageBean;
import com.project.entity.Teacher;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 16:41
 **/
public interface TeacherService {
    boolean add(Teacher teacher);
    boolean remove(Teacher teacher);
    boolean modify(Teacher teacher);
    Teacher getById(Teacher teacher);
    //查询全部的方法
    List<Teacher> getAll();
    //登录
    Teacher login(Teacher teacher);
    //批量删除
    boolean removeIds(int[] ids);
    //带条件的分页查询
    PageBean<Teacher> selectByPageIf(int currentPage, int pageSize, Teacher teacher);
}
