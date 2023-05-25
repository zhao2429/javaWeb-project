package ajax.loginregister.web.old; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 14:28
 **/


import ajax.loginregister.entity.User;
import ajax.loginregister.service.UserService;
import ajax.loginregister.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1:设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装对象
        User user = new User(username,password);
        //验证码验证
        //获取code.jpg的session对象，然后获取输入框中的内容进行对比
        String imgcode = (String) request.getSession().getAttribute("sessioncode");
        String checkCode = request.getParameter("checkCode");

        //对比验证码，出错直接返回
        if(checkCode.equalsIgnoreCase(imgcode)){
            //对比失败
            request.setAttribute("yzm_msg","验证码错误！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        //验证码正确

        //调用service方法
        boolean reg = userService.reg(user);
        //忽略大小写判断
        if (reg) {
            //成功
            request.setAttribute("login_msg","您注册成功可以进行登录！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //失败
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }
}
