package ajax.jsp.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/6 11:38
 **/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/JSTL01")
public class JSTLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这里模拟步骤


        //1：将数据存储到域对象中
        request.setAttribute("age",15);

        //2：转发到EL04.jsp中
        request.getRequestDispatcher("/EL04.jsp").forward(request,response);
    }
}
