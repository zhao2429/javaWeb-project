package ajax.loginregister.web.old; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 11:24
 **/


import ajax.loginregister.entity.User;
import ajax.loginregister.service.UserService;
import ajax.loginregister.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        //获取记住我复选框
        String remember = request.getParameter("remember");

        User user= userService.login(new User(username, password));

        if (user != null) {
            //查询登录成功
            if (user.getStatus() ==0) {
                request.setAttribute("login_msg","用户被禁用！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
            if ("1".equals(remember)) {
                //如果是勾选是则返回值1 ，
                //需要将登录信息存储到cookie中
                Cookie uname = new Cookie("username",username);
                Cookie pwd = new Cookie("password",password);

                //七天免登陆
                uname.setMaxAge(60*60*24*7);
                pwd.setMaxAge(60*60*24*7);
                //通知浏览器储存
                response.addCookie(uname);
                response.addCookie(pwd);
            }
            //不存储登录信息
            //将登录后的用户信息存储起来，用于整个网页的使用
            request.getSession().setAttribute("loginUser",user);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //失败
            //将错误信息存储
            request.setAttribute("login_msg","用户名或密码错误，请重新填写！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
