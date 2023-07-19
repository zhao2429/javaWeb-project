package com.project.servlet; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/7 11:11
 **/

import com.alibaba.fastjson.JSON;
import com.project.entity.PageBean;
import com.project.entity.Teacher;
import com.project.service.TeacherService;
import com.project.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/teacher/*")
public class TeacherServlet extends BaseServlet {
    private TeacherService teacherService = new TeacherServiceImpl();
    //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        //将字符串转换为json对象
        Teacher teacher = JSON.parseObject(line, Teacher.class);
        //调用方法验证
        Teacher tealogin = teacherService.login(teacher);
        //判断打印
        PrintWriter writer = response.getWriter();
        //将页面的对象和查询到的对象进行对比
        if (tealogin == null){
            //用户名不存在
            writer.write("-1");
            return;
        }
        if(!teacher.getPassword().equals(tealogin.getPassword())){
            //密码错误
            writer.write("-2");
            return;
        }
        //密码用户名都通过
        writer.write(tealogin.getUsername());
    }
    //带模糊条件查询的分页方法findAllByPageIf
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
        Teacher teacher = JSON.parseObject(line, Teacher.class);
        System.out.println("teacher = " + teacher);

        //通过service调用分页方法 ，list+count；判断是否带参数条件
        PageBean<Teacher> bean = teacherService.selectByPageIf(currentPage, pageSize,teacher);
        System.out.println("bean = " + bean);
        String s = JSON.toJSONString(bean);
        //System.out.println("s = " + s);
        response.getWriter().write(s);
    }
    //新增
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //将字符串转为对象
        Teacher teacher = JSON.parseObject(s, Teacher.class);
        boolean add = teacherService.add(teacher);
        response.getWriter().write(add?"success":"error");

    }

    //删除
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        String id = request.getParameter("id");
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(id));
        boolean remove = teacherService.remove(teacher);
        response.getWriter().write(remove?"success":"error");
    }

    //根据id查询
    protected void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        String id = request.getParameter("id");
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(id));

        Teacher byId = teacherService.getById(teacher);
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
        Teacher teacher = JSON.parseObject(s, Teacher.class);
        boolean modify = teacherService.modify(teacher);
        response.getWriter().write(modify?"success":"error");
    }

    //批量删除
    protected void deleteBatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //将字符串转为对象
        int[] ids = JSON.parseObject(s, int[].class);
        boolean byIds = teacherService.removeIds(ids);
        response.getWriter().write(byIds?"success":"error");
    }

}
