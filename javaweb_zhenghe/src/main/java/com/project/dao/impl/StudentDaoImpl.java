package com.project.dao.impl;

import com.project.dao.StudentDao;
import com.project.entity.Student;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/31 9:22
 **/
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public int insertStu(Student student) {
        String sql = "insert into student values(?,?,?,?,?,?)";
        return update(sql,0,
                student.getUsername(),
                student.getPassword(),
                student.getAge(),
                student.getPhone(),
                student.getStatus());
    }

    @Override
    public int deleteStu(Student student) {
        String sql = "delete from student where id = ?";
        return update(sql,student.getId());
    }

    @Override
    public int updateStu(Student student) {
        String sql = "update student set username = ? , password = ? , age = ? ,phone = ? , status = ? where id = ?";
        return update(sql ,
                student.getUsername(),
                student.getPassword(),
                student.getAge(),
                student.getPhone(),
                student.getStatus(),
                student.getId());
    }

    @Override
    public Student getById(Student student) {
        String sql = "select * from student where id = ?";
        return selectForOne(Student.class,sql,student.getId());
    }

    @Override
    public List<Student> getStuList() {
        String sql = "select * from student ";
        return selectForList(Student.class,sql);
    }

    @Override
    public Student selectByName(Student student) {
        String sql = "select * from student where username = ?";
        return selectForOne(Student.class,sql,student.getUsername());
    }

    @Override
    public int deleteByIdS(int[] ids) {
        String sql = "delete from student where id = ?";
        int count = 0;
        for (int i = 0; i < ids.length; i++) {
            count += update(sql,ids[i]);
        }
        return count;
    }

    @Override
    public List<Student> selectByPage(int begin, int pageSize) {
        String sql = "select * from student limit ? , ?";

        return selectForList(Student.class,sql,begin,pageSize);
    }

    @Override
    public int selectByPageCount() {
        String sql = "select count(*) from student";
        Number number = (Number) selectForValue(sql);
        return number.intValue();
    }


    @Override
    public List<Student> selectByPageIf(int begin, int pageSize, Student student) {
        //会判断是否为空，是否为空字符串 是否等于0
        boolean isusername = StringUtils.isNotBlank(student.getUsername());
        boolean isstatus = student.getStatus() != null;

        //sql可以变化，有条件和没有条件的需要变化，执行的sql也会不同
        //条件1和条件2可以使用一个变量来表示，但是变量需要根据实际情况来产生不同的写法，，如有条件username like ？ 没条件就是1 == ?
        //判断用户名设置username的条件
        //String username = student.getUsername()!= null?"username like ":"1 = ";
        String username = isusername?"username like ":"1 = ";

        //判断状态设置status的条件
        //String status = student.getStatus()!= null?"username":"1";
        String status = isstatus?"status ":"1 ";


        String sql = "select * from student where " + username + " ? and " + status + " = ? limit ?,?";
        //如果有username没有status
        //没有username没有status
        //有username有status
        //没有username没有status

        //判断条件指定需要的值(username like %姓名%) 有条件 ；没有条件 1=1
        String par1 = isusername?"%"+student.getUsername()+"%":"1";

        //判断条件指定需要的值(status = ) 有条件 ；没有条件 1=1
        int par2 = isstatus?student.getStatus():1;

        System.out.println("sql = " + sql);

        return selectForList(Student.class,sql,par1,par2,begin,pageSize);
    }

    @Override
    public int selectByPageCountIf(Student student) {
        boolean isusername = StringUtils.isNotBlank(student.getUsername());
        boolean isstatus = student.getStatus() != null;

        String username = isusername?"username like ":"1 = ";
        String status = isstatus?"status":"1";

        String sql = "select count(1) from student where " + username + " ? and " + status +"= ?";
        String par1 = isusername?"%"+student.getUsername()+"%":"1";

        //判断条件指定需要的值(status = ) 有条件 ；没有条件 1=1
        int par2 = isstatus?student.getStatus():1;
        Number number  = (Number) selectForValue(sql, par1, par2);
        return number.intValue();
    }
}
