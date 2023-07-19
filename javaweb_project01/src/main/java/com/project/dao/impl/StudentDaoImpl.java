package com.project.dao.impl;

import com.project.dao.StudentDao;
import com.project.entity.Student;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 14:20
 **/
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public Student selectByUserAndPassWord(Student student) {
        String sql = "select * from students where username = ? and password = ?";
        return selectForOne(Student.class,sql,student.getUsername(),student.getPassword());
    }

    @Override
    public Student selectByName(Student student) {
        String sql = "select * from students where username = ? ";
        return selectForOne(Student.class,sql,student.getUsername());
    }

    @Override
    public int insertStu(Student student) {
        String sql = "insert into students values(?,?,?,?,?,?)";
        return update(sql,0,
                student.getUsername(),
                student.getPassword(),
                student.getAge(),
                student.getPhone(),
                student.getGrade());
    }

    @Override
    public int deleteStu(Student student) {
        String sql = "delete from students where id = ?";
        return update(sql,student.getId());
    }

    @Override
    public int updateStu(Student student) {
        String sql = "update students set username = ? , password = ? , age = ? ,phone = ? , grade = ?  where id = ?";
        return update(sql ,
                student.getUsername(),
                student.getPassword(),
                student.getAge(),
                student.getPhone(),
                student.getGrade(),
                student.getId());
    }

    @Override
    public Student getById(Student student) {
       String sql = "select * from students where id = ?";
       return selectForOne(Student.class,sql,student.getId());
    }

    @Override
    public List<Student> getStuList() {
        String sql = "select * from students";
        return selectForList(Student.class,sql);
    }

    @Override
    public int deleteByIds(int[] ids) {
        String sql = "delete from students where id = ?";
        int count = 0;
        for (int i = 0; i < ids.length; i++) {
            count +=update(sql,ids[i]);
        }
        return count;
    }

    @Override
    public List<Student> selectByPageIf(int begin, int pageSize, Student student) {
        //判断是否有空，空对象，等于0
        boolean isusername = StringUtils.isNotBlank(student.getUsername());
        boolean isgrade = StringUtils.isNotBlank(student.getGrade());
        //条件
       String username = isusername?"username like ":" 1 = ";
       String grade = isgrade?"grade ":" 1 ";
       String sql ="select id,username,age,phone,grade from students where " + username + " ? and " + grade + " = ?  limit ?,?";

        System.out.println("sql = " + sql);

       //判断是否有条件
        String par1 = isusername?"%"+student.getUsername()+"%":"1";
        String par2 = isgrade?student.getGrade():"1";
        return selectForList(Student.class,sql,par1,par2,begin,pageSize);
    }

    @Override
    public int selectByPageCountIf(Student student) {
        //判断是否有空，空对象，等于0
        boolean isusername = StringUtils.isNotBlank(student.getUsername());
        boolean isgrade = StringUtils.isNotBlank(student.getGrade());
        //条件
        String username = isusername?" username like ":" 1 = ";
        String grade = isgrade?" grade ":" 1 ";
        String sql ="select count(1) from students where " + username + " ? and " + grade + " = ? ";

        System.out.println("sql = " + sql);

        //判断是否有条件
        String par1 = isusername?"%"+student.getUsername()+"%":"1";
        String par2 = isgrade?student.getGrade():"1";

        Number number = (Number) selectForValue(sql,par1,par2);

        return number.intValue();
    }
}
