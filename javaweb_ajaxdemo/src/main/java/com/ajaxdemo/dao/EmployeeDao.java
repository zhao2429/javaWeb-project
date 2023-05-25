package com.ajaxdemo.dao;


import com.ajaxdemo.entity.Employee;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 9:33
 **/

//定义项目需要实现的功能接口
public interface EmployeeDao {
    /**
     * 新增员工的方法
     * @param employee  需要新增的员工数据
     * @return 受影响行数
     */
    int insertEmployee(Employee employee);

    /**
     * 删除员工的方法
     * @param employee  需要新增的员工数据
     * @return 受影响行数
     */
    int deleteEmployee(Employee employee);

    /**
     * 修改员工的方法
     * @param employee  需要新增的员工数据
     * @return 受影响行数
     */
    int updateEmployee(Employee employee);

    /**
     * 根据id查询员工信息
     * @param employee 需要查询的员工对象
     * @return 查询后的员工完整信息
     */
    Employee selectById(Employee employee);

    /**
     * 查询全部的员工信息
     * @return 查询到的员工集合的信息
     */
    List<Employee>  selectByList();
}
