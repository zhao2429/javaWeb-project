package com.project.service;

import com.project.entity.Course;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/23 17:27
 **/
public interface CourseService {
    boolean add(Course course);
    boolean modify(Course course);
    Course getById(Course course);
    List<Course> getAll();
    Course getByImage(Course course);
}
