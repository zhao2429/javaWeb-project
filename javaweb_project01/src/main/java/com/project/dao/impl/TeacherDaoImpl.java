package com.project.dao.impl;

import com.project.dao.TeacherDao;
import com.project.entity.Teacher;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 14:43
 **/
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    @Override
    public Teacher selectByNameAndPassword(Teacher teacher) {
        String sql = "select * from teacher where username = ? and password = ?";
        return selectForOne(Teacher.class,sql,teacher.getUsername(),teacher.getPassword());

    }

    @Override
    public Teacher selectByName(Teacher teacher) {
        String sql = "select * from teacher where username = ? ";
        return selectForOne(Teacher.class,sql,teacher.getUsername());
    }

    @Override
    public int insertTea(Teacher teacher) {
        String sql = "insert into teacher values(?,?,?,?,?,?)";
        return update(sql,0,
                teacher.getUsername(),
                teacher.getPassword(),
                teacher.getAge(),
                teacher.getProject(),
                teacher.getGrade());
    }

    @Override
    public int deleteTea(Teacher teacher) {
        String sql = "delete from teacher where id = ?";
        return update(sql,teacher.getId());
    }

    @Override
    public int updateTea(Teacher teacher) {
        String sql = "update teacher set username = ? , password = ? , age = ? , project = ? , grade = ?  where id = ?";
        return update(sql ,
                teacher.getUsername(),
                teacher.getPassword(),
                teacher.getAge(),
                teacher.getProject(),
                teacher.getGrade(),
                teacher.getId());
    }

    @Override
    public Teacher getById(Teacher teacher) {
        String sql = "select * from teacher where id = ?";
        return selectForOne(Teacher.class,sql,teacher.getId());
    }

    @Override
    public List<Teacher> getTeaList() {
        String sql = "select * from teacher";
        return selectForList(Teacher.class,sql);
    }

    @Override
    public int deleteByIds(int[] ids) {
        String sql = "delete from teacher where id = ?";
        int count = 0;
        for (int i = 0; i < ids.length; i++) {
            count += update(sql,ids[i]);
        }
        return count;
    }

    @Override
    public List<Teacher> selectByPageIf(int begin, int pageSize, Teacher teacher) {
        boolean isusername = StringUtils.isNotBlank(teacher.getUsername());
        boolean isgrade = StringUtils.isNotBlank(teacher.getGrade());

        String username = isusername?"username like ":"1 = ";
        String grade = isgrade?"grade ":"1 ";
        String sql ="select id,username,age,project,grade from teacher where " + username + " ? and " + grade + " = ? limit ?,?";

        System.out.println("sql = " + sql);

        String par1 = isusername?"%"+teacher.getUsername()+"%":"1";
        String par2 = isgrade?teacher.getGrade():"1";
        return selectForList(Teacher.class,sql,par1,par2,begin,pageSize);

    }

    @Override
    public int selectByPageCountIf(Teacher teacher) {
        boolean isusername = StringUtils.isNotBlank(teacher.getUsername());
        boolean isgrade = StringUtils.isNotBlank(teacher.getGrade());

        String username = isusername?"username like ":"1 = ";
        String grade = isgrade?"grade ":"1 ";
        String sql ="select count(1) from teacher where " + username + " ? and " + grade + " = ? ";
        //System.out.println("sql = " + sql);

        String par1 = isusername?"%"+teacher.getUsername()+"%":"1";
        String par2 = isgrade?teacher.getGrade():"1";

        Number number = (Number) selectForValue(sql,par1,par2);
        return number.intValue();
    }
}
