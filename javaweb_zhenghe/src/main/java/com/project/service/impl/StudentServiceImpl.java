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
 * @DateTime: 2023/5/31 9:38
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
        return studentDao.selectByName(student);
    }

    @Override
    public boolean removeByIds(int[] ids) {

        return studentDao.deleteByIdS(ids) ==ids.length;
    }

    @Override
    public PageBean<Student> selectByPage(int currentPage, int pageSize) {
        //求出分页的开始索引
        int begin = (currentPage-1)*pageSize;
        //查询分页数据
        List<Student> studentList = studentDao.selectByPage(begin, pageSize);
        //分页的count
        int count = studentDao.selectByPageCount();
        PageBean<Student> studentPageBean = new PageBean<>(studentList,count);
        return studentPageBean;

    }

    @Override
    public PageBean<Student> selectByPageIf(int currentPage, int pageSize, Student student) {
        //求出分页的开始索引
        int begin = (currentPage-1)*pageSize;
        //查询分页数据,需要带条件
        List<Student> studentList = studentDao.selectByPageIf(begin, pageSize,student);
        //分页的count，带条件
        int count = studentDao.selectByPageCountIf(student);
        PageBean<Student> studentPageBean = new PageBean<>(studentList,count);
        return studentPageBean;

    }
}
