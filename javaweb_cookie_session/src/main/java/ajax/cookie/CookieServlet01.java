package ajax.cookie; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 14:54
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie01")
public class CookieServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //1:创建cookie
        Cookie cookie01 = new Cookie("username","张三");//通过构造方法添加保存的值
        Cookie cookie02 = new Cookie("password","123456");//通过构造方法添加保存的值
        //通过浏览器保存
        response.addCookie(cookie01);
        response.getWriter().write("您的cookie已经创建成功!");
        }
    }

