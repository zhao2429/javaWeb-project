package com.project.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/7 9:30
 **/
public class BaseServlet extends HttpServlet {
    //重写父类的service方法就会优先执行，其他子类继承该类会直接访问该类的service方法；
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在这调用子类的方法，切该方法是子类特有的，使用反射
        //获取到子类的字节码文件,this 就是调用service的子类方法且谁调就是谁
        //System.out.println("this = " + this);

        //0：根据请求获取请求地址
        String uri = req.getRequestURI(); //:/javaweb_login/user/login
        //System.out.println("requestURI = " + requestURI);
        //0.1:通过路径截取方法名
        String methodName = uri.substring(uri.lastIndexOf('/' )+1);//login

        //1：获取子类的对象用于反射获取需要执行的方法
        Class<? extends BaseServlet> aClass = this.getClass();

        //2：想要获取子类执行的方法
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            declaredMethod.setAccessible(true); //非public方法可以访问
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
