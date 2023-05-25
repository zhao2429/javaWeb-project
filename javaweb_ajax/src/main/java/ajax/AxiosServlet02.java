package ajax; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/16 15:04
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/axios02")
public class AxiosServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //如果post的请求传递数据的时候直接传入字符串,可以通过通用的方法获取

//        String username = request.getParameter("username");
//        System.out.println("username = " + username);

        //如果传入的是字符串，则无法通过通用的方法获取,则需要使用获取请求体的方式获取
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        System.out.println("s = " + s);
        //获取的格式为：
        //s = "{\"username\":\"张三\"}";
        response.getWriter().write("恭喜您！访问成功！！");
    }
}
