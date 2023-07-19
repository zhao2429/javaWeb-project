package com.project.service.impl;

import com.project.dao.AdminDao;
import com.project.dao.impl.AdminDaoImpl;
import com.project.entity.Admin;
import com.project.entity.PageBean;
import com.project.service.AdminService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 16:16
 **/
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(Admin admin) {
        return adminDao.selectByUserAndPassWord(admin);
    }

    @Override
    public Admin selectByName(Admin admin) {
        return adminDao.selectByAdmin(admin);
    }

    @Override
    public boolean register(Admin admin) {
        return adminDao.register(admin) > 0;
    }

    @Override
    public boolean modify(Admin admin) {
        return adminDao.updateAdmin(admin) > 0;
    }

    @Override
    public Admin getById(Admin admin) {
        return adminDao.getById(admin);
    }

    @Override
    public PageBean<Admin> selectByPageIf(int currentPage, int pageSize, Admin admin) {
        //求出分页的开始索引
        int begin = (currentPage-1)*pageSize;
        //查询分页数据,需要带条件
        List<Admin> adminList = adminDao.selectByPageIf(begin, pageSize,admin);
        //分页的count，带条件
        int count = adminDao.selectByPageCountIf(admin);
        PageBean<Admin> adminPageBean = new PageBean<>(adminList,count);
        return adminPageBean;
    }
}
