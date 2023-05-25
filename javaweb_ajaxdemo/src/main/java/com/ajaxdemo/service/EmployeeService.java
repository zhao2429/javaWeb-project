package com.ajaxdemo.service;


import com.ajaxdemo.entity.Employee;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 10:27
 **/
//service的方法接口
public interface EmployeeService {
    //新增
    boolean add(Employee employee);
    //删除
    boolean remove(Employee employee);
    //修改
    boolean modify(Employee employee);
    //根据id查询
    Employee findById(Employee employee);
    //查询全部
    List<Employee> findByAll();
}
