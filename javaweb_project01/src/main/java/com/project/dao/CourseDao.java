package com.project.dao;

import com.project.entity.Course;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/23 17:15
 **/
//作业表
public interface CourseDao {
//    新增
    int insertCourse(Course course);
    int updateCouse(Course course);
    Course getById(Course course);
//    查询全部
    List<Course> getCouList();
//获得图片的路径
    Course getImage(Course course);

}
