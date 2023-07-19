package com.project.dao;

import com.project.entity.Admin;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/5 10:38
 **/
public interface AdminDao {
    /**
     * 根据用户名和密码查询用户信息(登录)
     * @param admin 查询的时候传入的条件
     * @return 返回查询后
     */
    Admin selectByUserAndPassWord(Admin admin);

    /**
     * 查询用户名是否存在
     * @param admin
     * @return
     */
    Admin selectByAdmin(Admin admin);

    /**
     * 注册
     * @param admin
     * @return
     */
    int register(Admin admin);

    //新增
    int insertAdmin(Admin admin);
    //删除
    int deleteAdmin(Admin admin);
    //修改
    int updateAdmin(Admin admin);
    //查询单个
    Admin getById(Admin admin);
    //查询全部
    List<Admin> getStuList();

    //带条件查询分页方法
    /**
     * @param begin 这一页要显示的数据索引
     * @param pageSize 这一页需要显示几条
     * @return 返回查询的集合
     */
    List<Admin> selectByPageIf(int begin, int pageSize, Admin admin);
    //带条件查询数据总数
    int selectByPageCountIf(Admin admin);
}
