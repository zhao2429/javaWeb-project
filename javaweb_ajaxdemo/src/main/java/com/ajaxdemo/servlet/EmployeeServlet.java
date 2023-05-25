package com.ajaxdemo.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/17 16:38
 **/

import com.ajaxdemo.entity.Employee;
import com.ajaxdemo.service.EmployeeService;
import com.ajaxdemo.service.impl.EmployeeServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee/*")
public class EmployeeServlet extends BaseServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service方法
        List<Employee> byAll = employeeService.findByAll();
        //java转为字符串
        String s = JSON.toJSONString(byAll);
        //将结果响应给客户端
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(s);
    }


    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取数据
        BufferedReader reader = request.getReader();
        //获取到请求的字符串
        String s = reader.readLine();
        //在java中需要使用java对象来进行操作，需要将字符串转为java对象
        Employee employee = JSON.parseObject(s, Employee.class);
        response.getWriter().write(""+employeeService.add(employee));
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取数据
        BufferedReader reader = request.getReader();
        //获取到请求的字符串
        String s = reader.readLine();
        //在java中需要使用java对象来进行操作，需要将字符串转为java对象
        Employee employee = JSON.parseObject(s, Employee.class);
        response.getWriter().write(""+employeeService.remove(employee));
    }
}
