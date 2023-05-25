package ajax.login.dao;

import ajax.login.entity.Grade;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 20:59
 **/
public interface GradeDao {
    //新增信息
    int insertgraade(Grade grade);
    //删除信息
    int deletegrade(Grade grade);
    //修改信息
    int updategrade(Grade grade);
    //查询全部信息
    Grade selectById(Grade grade);
}
