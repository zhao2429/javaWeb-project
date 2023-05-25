package ajax.crud.test;

import ajax.crud.dao.EmployeeDao;
import ajax.crud.dao.impl.EmployeeImpl;
import ajax.crud.entity.Employee;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 10:14
 **/
public class DaoTest {
    public static void main(String[] args) {
        //新增
        EmployeeDao employeeDao =new EmployeeImpl();
        //Employee employee = new Employee("周星星", "123456", 55, "12345678911", 1);
        //int i = employeeDao.insertEmployee(employee);
        //System.out.println("i = " + i);

        //修改
//        Employee employee = new Employee(2,"周杰伦", "123456", 50, "12345678911", 1);
//        int i = employeeDao.updateEmployee(employee);
//        System.out.println("i = " + i);

        //删除
//        Employee employee = new Employee(2);
//        int i = employeeDao.deleteEmployee(employee);
//        System.out.println("i = " + i);

        //查询单个
//        Employee employee = new Employee(1);
//        Employee employee1 = employeeDao.selectById(employee);
//        System.out.println("employee1 = " + employee1);

        //查询全部
        List<Employee> employees = employeeDao.selectByList();
        System.out.println("employees = " + employees);

    }
}
