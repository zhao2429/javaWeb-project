package ajax.login.service.impl;

import ajax.login.dao.StudentDao;
import ajax.login.dao.impl.StudentDaoImpl;
import ajax.login.entity.Student;
import ajax.login.service.StudentService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 16:07
 **/
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao =new StudentDaoImpl();
    @Override
    public boolean add(Student student) {
        return studentDao.insertStu(student) > 0;
    }

    @Override
    public boolean delete(Student student) {
        return studentDao.deleteStu(student) >0;
    }

    @Override
    public boolean update(Student student) {
        return studentDao.updateStu(student) >0;
    }

    @Override
    public Student selectById(Student student) {
        return studentDao.selectById(student);
    }

    @Override
    public List<Student> selectList() {
        return studentDao.selectList();
    }
}
