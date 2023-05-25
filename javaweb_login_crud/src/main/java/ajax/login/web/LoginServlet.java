package ajax.login.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 10:21
 **/

import ajax.login.entity.User;
import ajax.login.service.UserService;
import ajax.login.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取页面参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装为对象
        User user = new User(username,password);
        //调用方法
        User login = userService.login(user);

        //5：判断查询结果有没有值
        if (login == null){
            //登录失败
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        if (login.getStatus() !=1){
            //账户禁用
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }

        //成功
        response.sendRedirect(request.getContextPath()+"/list");
    }
}
