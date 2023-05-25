package ajax.login.dao.impl;

import ajax.login.dao.GradeDao;
import ajax.login.entity.Grade;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 21:00
 **/
public class GradeDaoImpl extends BaseDao implements GradeDao {

    @Override
    public int insertgraade(Grade grade) {
        String sql = "insert into grade(gradeId,gradeName) values(?,?)";
        return update(sql,grade.getGradeId(),grade.getGradeName());
    }

    @Override
    public int deletegrade(Grade grade) {
        String sql = "delete from grade where gradeId = ?";
        return update(sql,grade.getGradeId());
    }

    @Override
    public int updategrade(Grade grade) {
        String sql = "update grade set gradeName = ? where gradeId= ?";
        return update(sql,grade.getGradeName(),grade.getGradeId());
    }

    @Override
    public Grade selectById(Grade grade) {
        String sql = "select * from grade where gradeId = ?";
        return selectForOne(Grade.class,sql,grade.getGradeId());
    }
}
