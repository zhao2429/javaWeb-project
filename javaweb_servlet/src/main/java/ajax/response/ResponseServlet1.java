package ajax.response; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/28 9:27
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rs01")
public class ResponseServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问servlet后响应一些东西回到客户端；；；响应行，响应头，响应体
        System.out.println("我现在已经不处理这个事情了，请访问其小明！");
        //1：响应行中，响应状态码
        //response.setStatus(302); //表示访问当前的servlet，发生了重定向

        //2:设置响应头，，重定向后跳转的地址
        //这个地址是给浏览器用的  /  它识别为http://localhost:8080/rs302
        //response.setHeader("Location","/javaweb_servlet/rs302");
        //灵活获取项目名，防止频繁修改
        //response.setHeader("Location",request.getContextPath()+"/rs302");

        //response对象的方法完成重定向操作（推荐使用）
        response.sendRedirect(request.getContextPath()+"/rs302");
        //response.sendRedirect(request.getContextPath()+"/index.jsp");  //不能访问

        //response.sendRedirect("http://www.baidu.com"); //可以访问
    }
}
