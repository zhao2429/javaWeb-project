package com.project.dao.impl;

import com.project.dao.CourseDao;
import com.project.entity.Course;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/23 17:20
 **/
public class CourseDaoImpl extends BaseDao implements CourseDao {
    @Override
    public int insertCourse(Course course) {
        String sql = "insert into course(teachername,workname,starttime,endtime,homework) values (?,?,?,?,?)";
        return update(sql, course.getTeachername(),
                course.getWorkname(),
                course.getStarttime(),
                course.getEndtime(),
                course.getHomework());
    }

    @Override
    public int updateCouse(Course course) {
        String sql = "update course set image = ?  where id = ?";
        return update(sql ,course.getImage(),
                course.getId());
    }

    @Override
    public Course getById(Course course) {
        String sql = "select * from course where id = ?";
        return selectForOne(Course.class,sql,course.getId());
    }

    @Override
    public List<Course> getCouList() {
        String sql = "select * from course";
        return selectForList(Course.class,sql);
    }

    @Override
    public Course getImage(Course course) {
        String sql = "select image from course where id = ? ";
        return selectForOne(Course.class,sql,course.getId());
    }
}
