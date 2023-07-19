package com.project.service.impl;

import com.project.dao.CourseDao;
import com.project.dao.impl.CourseDaoImpl;
import com.project.entity.Course;
import com.project.service.CourseService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/23 17:28
 **/
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();
    @Override
    public boolean add(Course course) {
        return courseDao.insertCourse(course) > 0;
    }

    @Override
    public boolean modify(Course course) {
        return courseDao.updateCouse(course) > 0;
    }

    @Override
    public Course getById(Course course) {
        return courseDao.getById(course);
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getCouList();
    }

    @Override
    public Course getByImage(Course course) {
        return courseDao.getImage(course);
    }
}
