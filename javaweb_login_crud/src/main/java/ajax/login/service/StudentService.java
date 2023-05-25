package ajax.login.service;

import ajax.login.entity.Student;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 16:04
 **/
public interface StudentService {
    //新增
    boolean add(Student student);
    //删除
    boolean delete(Student student);
    //修改
    boolean update(Student student);
    //根据id查询
    Student selectById(Student student);
    //查询全部
    List<Student> selectList();
}
