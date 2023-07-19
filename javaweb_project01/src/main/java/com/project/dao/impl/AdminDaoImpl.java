package com.project.dao.impl;

import com.project.dao.AdminDao;
import com.project.entity.Admin;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/6 11:16
 **/
public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public Admin selectByUserAndPassWord(Admin admin) {
        String sql = "select * from admin where username = ? and password = ?";
        return selectForOne(Admin.class,sql,admin.getUsername(),admin.getPassword());
    }

    @Override
    public Admin selectByAdmin(Admin admin) {
        String sql ="select * from admin where username = ? ";
        return selectForOne(Admin.class,sql,admin.getUsername());
    }

    @Override
    public int register(Admin admin) {
        String sql = "insert into admin(username,password) values(?,?)";
        return update(sql,admin.getUsername(),admin.getPassword());
    }

    @Override
    public int insertAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int deleteAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        String sql = "update admin set username = ? , password = ? where id = ? ";
        return update(sql,admin.getUsername(),admin.getPassword(),admin.getId());
    }

    @Override
    public Admin getById(Admin admin) {
        String sql = "select * from admin where id = ?";
        return selectForOne(Admin.class,sql,admin.getId());
    }

    @Override
    public List<Admin> getStuList() {
        String sql = "select * from admin";
        return selectForList(Admin.class,sql);
    }

    @Override
    public List<Admin> selectByPageIf(int begin, int pageSize, Admin admin) {
        //判断是否为空
        boolean isusername = StringUtils.isNotBlank(admin.getUsername());
        String username = isusername?"username like ":"1 = ";
        String sql = "select id,username from admin where " + username + " ?  limit ?,?";
        String par1 = isusername?"%"+admin.getUsername()+"%":"1";
        return selectForList(Admin.class,sql,par1,begin,pageSize);
    }

    @Override
    public int selectByPageCountIf(Admin admin) {
        //判断是否为空
        boolean isusername = StringUtils.isNotBlank(admin.getUsername());
        String username = isusername?"username like ":"1 = ";
        String sql = "select count(1) from admin where " + username + " ?";
        String par1 = isusername?"%"+admin.getUsername()+"%":"1";
        Number number = (Number) selectForValue(sql, par1);
        return number.intValue();
    }
}
