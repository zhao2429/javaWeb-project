package ajax.login.service;

import ajax.login.entity.Grade;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 10:15
 **/
public interface GradeService {
    //新增
    boolean add(Grade grade);
    //删除
    boolean delete(Grade grade);
    //修改
    boolean update(Grade grade);
}
