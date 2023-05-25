package ajax.login.dao;

import ajax.login.entity.Student;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 15:47
 **/
public interface StudentDao {
    /**
     * 新增学生方法
     * @param student
     * @return
     */
    int insertStu(Student student);

    /**
     * 删除学生信息方法
     * @param student
     * @return
     */
    int deleteStu(Student student);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    int updateStu(Student student);

    /**
     * 根据id查询学生信息
     * @param student
     * @return
     */
    Student selectById(Student student);

    /**
     * 查询全部学生信息
     * @return
     */
    List<Student>  selectList();
}
