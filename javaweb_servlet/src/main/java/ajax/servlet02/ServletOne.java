package ajax.servlet02;
/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 15:39
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//urlPatterns  表示的是servlet访问的路径
//1：配置一个路径，表示访问房钱项目路径会被servlet执行
//@WebServlet(urlPatterns = "/ServletOne")
//@WebServlet("/ServletOne")

//2:配置多个servlet的访问路径
//@WebServlet(urlPatterns = {"/s01","s02"})

//3：精确匹配，当不同的servlet访问路径相同可以加一个路径匹配不同的操作
//@WebServlet("/student/getall")

//4:目录匹配。只要是/student下任何请求都会被servlet接收到
//@WebServlet("/student/*")

//5：扩展名匹配
//@WebServlet("*.do")

//6：任意匹配，所有请求都会匹配
//@WebServlet("/*")

@WebServlet("/test")
public class ServletOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET执行了");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post执行了");
    }
}
