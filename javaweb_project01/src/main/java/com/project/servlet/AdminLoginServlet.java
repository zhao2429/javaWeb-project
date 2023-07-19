package com.project.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/7 9:32
 **/

import com.alibaba.fastjson.JSON;
import com.project.entity.Admin;
import com.project.entity.PageBean;
import com.project.service.AdminService;
import com.project.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/*")
public class AdminLoginServlet extends BaseServlet {
   private AdminService adminService = new AdminServiceImpl();
   //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        //将字符串转换为json对象
        Admin admin = JSON.parseObject(line, Admin.class);
        //调用方法验证
        Admin dataadmin = adminService.login(admin);
        //判断打印
        PrintWriter writer = response.getWriter();
        //将页面的对象和查询到的对象进行对比
        if (dataadmin == null){
            //用户名不存在
            writer.write("-1");
            return;
        }
        if(!admin.getPassword().equals(dataadmin.getPassword())){
            //密码错误
            writer.write("-2");
            return;
        }
        //密码用户名都通过
        writer.write(dataadmin.getUsername());
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        //将字符串转换为json对象
        Admin admin = JSON.parseObject(line, Admin.class);
        //调用方法验证
        boolean register = adminService.register(admin);
        response.getWriter().write(register?"success":"error");
    }

    protected void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        String username = request.getParameter("username");
        Admin admin = new Admin();
        admin.setUsername(username);
        //将字符串转换为json对象
//        Admin admin = JSON.parseObject(line, Admin.class);
        System.out.println("admin = " + admin);
        //调用方法验证
        Admin byName = adminService.selectByName(admin);
        //判断打印
        PrintWriter writer = response.getWriter();
        //将页面的对象和查询到的对象进行对比
        if (byName != null){
            //用户名不存在
            writer.write("error");
            return;
        }else{
            //用户名重复
            writer.write("success");
            return;
        }
    }
    //带条件查询
    protected void findAllByPageIf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取当前页和显示条数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        //接收条件
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        //将条件封装为一个对象
        Admin admin = JSON.parseObject(line, Admin.class);

        //通过service调用分页方法 ，list+count；判断是否带参数条件
        PageBean<Admin> bean = adminService.selectByPageIf(currentPage, pageSize,admin);
        System.out.println("bean = " + bean);
        String s = JSON.toJSONString(bean);
        //System.out.println("s = " + s);
        response.getWriter().write(s);
    }
    protected void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        String id = request.getParameter("id");
        Admin admin = new Admin();
        admin.setId(Integer.parseInt(id));

        Admin byId = adminService.getById(admin);
        //将对象转为json响应给axios
        response.getWriter().write(JSON.toJSONString(byId));
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //将字符串转为对象
        Admin admin = JSON.parseObject(s, Admin.class);
        boolean modify = adminService.modify(admin);
        response.getWriter().write(modify?"success":"error");
    }
}
