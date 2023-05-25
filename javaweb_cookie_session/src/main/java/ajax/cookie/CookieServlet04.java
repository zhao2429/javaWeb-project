package ajax.cookie; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 16:14
 **/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cookie04")
public class CookieServlet04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Cookie cookie = new Cookie("pwd","123");
        //设置cookie的存活时间,存活一个星期
        //cookie.setMaxAge(604800);
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);

    }
}
