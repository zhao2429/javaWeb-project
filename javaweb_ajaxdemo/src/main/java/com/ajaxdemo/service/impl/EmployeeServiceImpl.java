package com.ajaxdemo.service.impl;


import com.ajaxdemo.dao.EmployeeDao;
import com.ajaxdemo.dao.impl.EmployeeImpl;
import com.ajaxdemo.entity.Employee;
import com.ajaxdemo.service.EmployeeService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 10:29
 **/
//service的接口实现类
public class EmployeeServiceImpl implements EmployeeService {
    //调用dao层的实现方法
    private EmployeeDao employeeDao = new EmployeeImpl();
    @Override
    public boolean add(Employee employee) {
        return employeeDao.insertEmployee(employee) > 0;
    }

    @Override
    public boolean remove(Employee employee) {
        return employeeDao.deleteEmployee(employee)>0;
    }

    @Override
    public boolean modify(Employee employee) {
        return employeeDao.updateEmployee(employee)>0;
    }

    @Override
    public Employee findById(Employee employee) {
        return employeeDao.selectById(employee);
    }

    @Override
    public List<Employee> findByAll() {
        return employeeDao.selectByList();
    }

}
