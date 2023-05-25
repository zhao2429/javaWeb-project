package ajax.response; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/28 10:39
 **/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/rs02")
public class ResponseServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置响应字符的编码
        //response.setCharacterEncoding("utf-8");
        //设置响应内容的类型
       //response.setHeader("Content-type","text/html");

       //同时设置编码和类型
        response.setContentType("text/html;charset=utf-8");

        //向浏览器响应一个字符串
        //1：通过response获取字符输出流
        PrintWriter writer = response.getWriter();
        //2：使用输出流中的write方法向浏览器写内容
        writer.write("您好！");

    }
}
