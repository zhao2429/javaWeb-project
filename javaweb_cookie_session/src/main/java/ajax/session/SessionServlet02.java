package ajax.session; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 16:41
 **/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/session02")
public class SessionServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取session中的值
        HttpSession session = request.getSession();
        Object key01 = session.getAttribute("key01");
        System.out.println("key01 = " + key01);

        response.getWriter().write("我获取的值为："+key01);
    }
}
