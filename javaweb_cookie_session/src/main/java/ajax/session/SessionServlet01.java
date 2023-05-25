package ajax.session; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 16:39
 **/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/session01")
public class SessionServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("key01","values01");

        //超时的时间，秒为单位
        //session.setMaxInactiveInterval();
        response.getWriter().write("您成功创建了session对象，这边已经存储数据！！");
    }
}
