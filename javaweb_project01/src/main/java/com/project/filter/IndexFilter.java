package com.project.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/29 8:54
 **/


//@WebFilter("/*")
public class IndexFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        //定义好不需要拦截直接可以访问的路径
        String[] urls = {"/imgs/","/css/","/js/","/element-ui/","/login.html","/admin/","/student/login","/teacher/login"};

        //查看当前请求路径
        String url = request1.getRequestURL().toString();
        //对比数组是否需要直接放行
        for(String s :urls){
            //对比路径中是否有需要放行的路径
            if(url.contains(s)){
                //在数组中找到和请求路径中相同的字符串
                chain.doFilter(request,response);
                return;
            }
        }
        //获取所有的cookie
        Cookie[] cookies = request1.getCookies();
        String radio = null;
        if (cookies != null) {
            //遍历
            for (Cookie cookie : cookies) {
                if ("radio".equals(cookie.getName())) {
                    radio = cookie.getValue();
                    break;
                }
            }
        }
        //判断cookie的值是哪类用户
        if (radio == "1") {
            //如果是管理员全部放行
            String u = ("/*");
            String requestURI = request1.getRequestURI();
            //判断请求的页面
            if (requestURI.endsWith(u)) {
                chain.doFilter(request, response);
            }
        } else if (radio == "2") {
            //如果是老师
            String u = ("/admin_info.html");
            String requestURI = request1.getRequestURI();
            //判断请求的页面
            if (!requestURI.endsWith(u)) {
                chain.doFilter(request, response);
            } else {
                response.getWriter().write("teacherError");
            }

        } else if (radio == "3") {
            //如果是学生
            String[] ur = {"/student_info.html","/student_score.html","/student_tasksShow.html","/studentLeave_info.html","/indexHome.html","/campus_news.html","/campus_style.html","/student/findAllByPageIf","/course/getAll"};
            String requestURI = request1.getRequestURI();
            boolean  isAllowed  =  false;
            //判断请求的页面
            for (String s : ur){
                if (requestURI.endsWith(s)){
                    isAllowed  =  true;
                    break;
                }
                if  (isAllowed)  {
                    chain.doFilter(request,  response);
                }  else  {
                    response.getWriter().write("studentError");
                }
            }

        }
    }
}

