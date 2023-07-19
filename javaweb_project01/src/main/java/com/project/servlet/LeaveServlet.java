package com.project.servlet;

import com.alibaba.fastjson.JSON;
import com.project.entity.Leave;
import com.project.entity.PageBean;
import com.project.service.LeaveService;
import com.project.service.impl.LeaveServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 11:11
 **/
@WebServlet("/leave/*")
public class LeaveServlet extends BaseServlet{
    private LeaveService leaveService = new LeaveServiceImpl();
//    新增
protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/json;charset=UTF-8");
    //获取请求体数据
    BufferedReader reader = request.getReader();
    String s = reader.readLine();
    //将字符串转为对象
    Leave leave = JSON.parseObject(s, Leave.class);
    boolean add = leaveService.add(leave);
    response.getWriter().write(add?"success":"error");
    }
    //分页查询全部.findAllByPage
    protected void findAllByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取当前页和显示条数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //通过service调用分页方法 ，list+count
        PageBean<Leave> bean = leaveService.selectByPage(currentPage, pageSize);

        String s = JSON.toJSONString(bean);
        response.getWriter().write(s);
    }

}
