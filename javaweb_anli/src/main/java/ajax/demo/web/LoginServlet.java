package ajax.demo.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 11:24
 **/

import ajax.demo.entity.User;
import ajax.demo.service.UserService;
import ajax.demo.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //创建userservice对象
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实现请求的实现
        //1：设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //2:获取页面参数（返回值为string类型 其他涉及到的类型需要转换）
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //3:将参数封装作为对象
        User user = new User(username,password);

        //4:调用service方法，传入参数进行功能的调用
        User login = userService.login(user);
        System.out.println("login = " + login);

        //5：判断查询结果有没有值
        if (login == null){
            //登录失败
            request.getRequestDispatcher("/login.html").forward(request,response);
            return;
        }
        if (login.getStatus() !=1){
            //账户禁用
            request.getRequestDispatcher("/login.html").forward(request,response);
            return;
        }

        //成功
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
