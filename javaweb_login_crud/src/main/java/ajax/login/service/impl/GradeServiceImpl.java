package ajax.login.service.impl;

import ajax.login.dao.GradeDao;
import ajax.login.dao.impl.GradeDaoImpl;
import ajax.login.entity.Grade;
import ajax.login.service.GradeService;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 10:16
 **/
public class GradeServiceImpl implements GradeService {
    private GradeDao gradeDao = new GradeDaoImpl();
    @Override
    public boolean add(Grade grade) {
        return gradeDao.insertgraade(grade) > 0;
    }

    @Override
    public boolean delete(Grade grade) {
        return gradeDao.deletegrade(grade)>0;
    }

    @Override
    public boolean update(Grade grade) {
        return gradeDao.updategrade(grade) >0;
    }
}
