package com.project.service;

import com.project.entity.Admin;
import com.project.entity.PageBean;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 14:56
 **/
public interface AdminService {
    //登录
    Admin login(Admin admin);
    //查询姓名
    Admin selectByName(Admin admin);
    //注册
    boolean register(Admin admin);
    //修改
    boolean modify(Admin admin);

    //查询id
    Admin getById(Admin admin);
    //条件分页
    PageBean<Admin> selectByPageIf(int currentPage, int pageSize,Admin admin);


}
