package com.ajaxdemo.dao.impl;


import com.ajaxdemo.dao.EmployeeDao;
import com.ajaxdemo.entity.Employee;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 9:40
 **/
//方法接口的实现类
public class EmployeeImpl extends BaseDao implements EmployeeDao {
    @Override
    public int insertEmployee(Employee employee) {
        String sql = "insert into employee values(?,?,?,?,?,?)";
        return update(sql,
                0,
                employee.getUserName(),
                employee.getPassWord(),
                employee.getAge(),
                employee.getPhone(),
                employee.getStatus());
    }

    @Override
    public int deleteEmployee(Employee employee) {
        String sql = "delete from employee where id = ?";
        return update(sql,employee.getId());
    }

    @Override
    public int updateEmployee(Employee employee) {
        String sql = "update employee set username = ?,password = ?,age = ?,phone = ?,status = ? where id = ?";
        return update(sql,
                employee.getUserName(),
                employee.getPassWord(),
                employee.getAge(),
                employee.getPhone(),
                employee.getStatus(),
                employee.getId());
    }

    @Override
    public Employee selectById(Employee employee) {
        String sql = "select * from employee where id = ?";
        return selectForOne(Employee.class,sql,employee.getId());
    }

    @Override
    public List<Employee> selectByList() {
        String sql = "select * from employee";
        return selectForList(Employee.class,sql);
    }
}
