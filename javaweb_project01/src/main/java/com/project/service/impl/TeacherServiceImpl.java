package com.project.service.impl;

import com.project.dao.TeacherDao;
import com.project.dao.impl.TeacherDaoImpl;
import com.project.entity.PageBean;
import com.project.entity.Teacher;
import com.project.service.TeacherService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 16:43
 **/
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public boolean add(Teacher teacher) {
        return teacherDao.insertTea(teacher) > 0;
    }

    @Override
    public boolean remove(Teacher teacher) {
        return teacherDao.deleteTea(teacher) > 0;
    }

    @Override
    public boolean modify(Teacher teacher) {
        return teacherDao.updateTea(teacher) > 0;
    }

    @Override
    public Teacher getById(Teacher teacher) {
        return teacherDao.getById(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getTeaList();
    }

    @Override
    public Teacher login(Teacher teacher) {
        return teacherDao.selectByNameAndPassword(teacher);
    }

    @Override
    public boolean removeIds(int[] ids) {
        return teacherDao.deleteByIds(ids) == ids.length;
    }

    @Override
    public PageBean<Teacher> selectByPageIf(int currentPage, int pageSize, Teacher teacher) {
        int begin = (currentPage-1)*pageSize;
        List<Teacher> teachers = teacherDao.selectByPageIf(begin, pageSize, teacher);
        int i = teacherDao.selectByPageCountIf(teacher);
        PageBean<Teacher> pageBean = new PageBean<>(teachers,i);
        return pageBean;
    }
}
