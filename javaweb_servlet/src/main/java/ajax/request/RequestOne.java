package ajax.request;
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
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/test01")
public class RequestOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1：获取请求行的内容
        /*1：获取亲请求的方式*/
        String method = request.getMethod();  //get
        System.out.println("method = " + method);

        //2：获取项目路径（虚拟目录，项目名）
        String contextPath = request.getContextPath(); // /javaweb_servlet_war_exploded
        System.out.println("contextPath = " + contextPath);

        //3：获取项目的同一资源，定位符 URL
        StringBuffer requestURL = request.getRequestURL();  //完整的资源路径http://localhost:8080/javaweb_servlet_war_exploded/test01
        System.out.println("requestURL = " + requestURL.toString());

        //4：获取同一资源标识符
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        //5：获取请求参数（get方式）
        String queryString = request.getQueryString(); //test01?username=zs&password=123456
        System.out.println("queryString = " + queryString);

        /*2：获取请求头  key：value*/
        //User-Agent：浏览器的版本信息
        String header = request.getHeader("User-Agent");
        System.out.println("header = " + header);

        //请求头较多根据需求使用key即可

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3：获取请求体数据 ，get没有请求体，我们需要使用post请求
        System.out.println("访问成功!");
        //1:获取post请求体数据
        //字符输入流
        BufferedReader reader = request.getReader();
        //需要从流中读取信息
        String s = reader.readLine();
        System.out.println("s = " + s);
    }
}
