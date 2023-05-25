package ajax.login.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 10:37
 **/

import ajax.login.entity.User;
import ajax.login.service.UserService;
import ajax.login.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/zhuce")
public class ZhuCeServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        boolean zhuce = userService.zhuce(user);

        if (zhuce){
            //成功
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            //失败
            request.getRequestDispatcher("/zhuce.html").forward(request,response);
        }

    }
}
