package com.project.servlet;

import com.alibaba.fastjson.JSON;
import com.project.entity.Course;
import com.project.service.CourseService;
import com.project.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 15:40
 **/
@WebServlet("/course/*")
@MultipartConfig
public class CourseServlet extends BaseServlet{
    private CourseService courseService = new CourseServiceImpl();
    //    新增
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //将字符串转为对象
        Course course = JSON.parseObject(s, Course.class);
        boolean add = courseService.add(course);
        response.getWriter().write(add?"success":"error");
    }
    //根据id查询
    protected void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        String id = request.getParameter("id");
        Course course = new Course();
        course.setId(Integer.parseInt(id));

        Course byId = courseService.getById(course);
        //将对象转为json响应给axios
        response.getWriter().write(JSON.toJSONString(byId));
    }

    //修改信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //将字符串转为对象
        Course course = JSON.parseObject(s, Course.class);
        boolean modify = courseService.modify(course);
        response.getWriter().write(modify?"success":"error");
    }
    protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //调用service方法
        List<Course> all = courseService.getAll();
        //java转为字符串
        String s = JSON.toJSONString(all);
        //将结果响应给客户端
        response.getWriter().write(s);
    }
}
