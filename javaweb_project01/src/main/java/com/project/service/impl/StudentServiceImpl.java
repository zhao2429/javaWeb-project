package com.project.service.impl;

import com.project.dao.StudentDao;
import com.project.dao.impl.StudentDaoImpl;
import com.project.entity.PageBean;
import com.project.entity.Student;
import com.project.service.StudentService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 16:34
 **/
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public boolean add(Student student) {
        return studentDao.insertStu(student) > 0;
    }

    @Override
    public boolean remove(Student student) {
        return studentDao.deleteStu(student) > 0;
    }

    @Override
    public boolean modify(Student student) {
        return studentDao.updateStu(student) > 0;
    }

    @Override
    public Student getById(Student student) {
        return studentDao.getById(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getStuList();
    }

    @Override
    public Student login(Student student) {
        return studentDao.selectByUserAndPassWord(student);
    }

    @Override
    public boolean removeIds(int[] ids) {
        return studentDao.deleteByIds(ids) == ids.length;
    }

    @Override
    public PageBean<Student> selectByPageIf(int currentPage, int pageSize, Student student) {
        //开始的索引
        int begin = (currentPage-1)*pageSize;
        //查询分页数据
        List<Student> students = studentDao.selectByPageIf(begin, pageSize, student);
        //分页的总数
        int count = studentDao.selectByPageCountIf(student);

        PageBean<Student> pageBean = new PageBean<>(students,count);

        return pageBean;
    }
}
