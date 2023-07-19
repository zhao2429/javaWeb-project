package com.project.servlet;

import com.alibaba.fastjson.JSON;
import com.project.entity.PageBean;
import com.project.entity.Score;
import com.project.service.ScoreService;
import com.project.service.impl.ScoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 15:40
 **/
@WebServlet("/score/*")
public class ScoreServlet extends BaseServlet{
    private ScoreService scoreService = new ScoreServiceImpl();
    //    新增
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //将字符串转为对象
        Score score = JSON.parseObject(s, Score.class);
        boolean add = scoreService.add(score);
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
        PageBean<Score> bean = scoreService.selectByPage(currentPage, pageSize);

        String s = JSON.toJSONString(bean);
        response.getWriter().write(s);
    }

}
