package com.demo.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/27 15:30
 **/

import com.alibaba.fastjson.JSON;
import com.demo.entity.Job;
import com.demo.service.JobService;
import com.demo.service.impl.JobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/job/*")
public class JobServlet extends BaseServlet {
    private JobService jobService = new JobServiceImpl();
    //登录功能

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取数据
        BufferedReader reader = request.getReader();
        //获取到请求的字符串
        String s = reader.readLine();
        //在java中需要使用java对象来进行操作，需要将字符串转为java对象
        Job job = JSON.parseObject(s, Job.class);
        response.getWriter().write(""+jobService.login(job));
    }
    //模糊查询
    protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取数据
        BufferedReader reader = request.getReader();
        //获取到请求的字符串
        String s = reader.readLine();
        //在java中需要使用java对象来进行操作，需要将字符串转为java对象
        Job job = JSON.parseObject(s, Job.class);
        //调用方法
        List<Job> list = jobService.find(job);
        //将结果转为字符串
        String str = JSON.toJSONString(list);

        System.out.println("str = " + str);
        response.getWriter().write(str);
    }

    //查询全部
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service方法
        List<Job> byAll = jobService.findByAll();
        //java转为字符串
        String s = JSON.toJSONString(byAll);
        //将结果响应给客户端
        response.setContentType("application/json;charset=UTF-8");
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
        Job job = JSON.parseObject(s, Job.class);
        response.getWriter().write(""+jobService.add(job));
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //获取数据
        BufferedReader reader = request.getReader();
        //获取到请求的字符串
        String s = reader.readLine();
        //在java中需要使用java对象来进行操作，需要将字符串转为java对象
        Job job = JSON.parseObject(s, Job.class);
        response.getWriter().write(""+jobService.remove(job));
    }
}
