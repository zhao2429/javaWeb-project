package ajax.login.dao.impl;

import ajax.login.dao.GradeDao;
import ajax.login.dao.StudentDao;
import ajax.login.entity.Grade;
import ajax.login.entity.Student;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 15:52
 **/
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public int insertStu(Student student) {
        GradeDao gradeDao = new GradeDaoImpl();
        String sql = "insert into student(name,borntime,sex,gradeId) values(?,?,?,?)";
        int update = update(sql, student.getName(), student.getBorntime(), student.getSex(), student.getGradeId());
        return update;
    }

    @Override
    public int deleteStu(Student student) {
        String sql = "delete from student where id = ?";
        return update(sql,student.getId());
    }

    @Override
    public int updateStu(Student student) {
        String sql = "update student set name = ?,borntime = ?,sex = ?,gradeId = ? where id = ?";
        return update(sql,student.getName(),student.getBorntime(),student.getSex(),student.getGradeId(),student.getId());
    }

    @Override
    public Student selectById(Student student) {
        String sql = "select * from student where id = ?";
        return selectForOne(Student.class,sql,student.getId());
    }

    @Override
    public List<Student> selectList() {
        //String sql = "select * from student";

        String sql="select * from student as s inner join grade as g on s.gradeId = g.gradeId";
        //List<Student> students = selectForList(Student.class, sql);
        //写一个可以查询连接查询的方法
        GradeDao gradeDao = new GradeDaoImpl();
        List<Student> students = selectForList(Student.class, sql);
        //System.out.println(students);
        //遍历students   1
        for(int i = 0; i < students.size(); i++){
            Grade grade = gradeDao.selectById(new Grade(students.get(i).getGradeId()));
            students.get(i).setGrade(grade);
        }
        return students;
    }
}
