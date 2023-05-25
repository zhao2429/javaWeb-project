package ajax.loginregister.web;

import ajax.loginregister.entity.User;
import ajax.loginregister.service.UserService;
import ajax.loginregister.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/13 14:47
 **/


//该类用于书写关于user的所有的servlet功能
@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    UserService userService = new UserServiceImpl();
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

                //cookie发送数据给服务器是有要求的，只是在当前路径下资源才可以访问
                //http://localhost:8080/javaweb_login/user/login
                /*如 username这个cookie 存在于//http://localhost:8080/javaweb_login/user/login
                * 那么只要路径不带/user/都无法传输cookie到servlet
                * 所以我们将cookie的过来的路径直接设置为当前项目，，不分路径
                * */
//                uname.setPath(request.getContextPath());
//                pwd.setPath(request.getContextPath());

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



protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//        System.out.println("checkCode = " + checkCode);
//        System.out.println("imgcode = " + imgcode);

        //对比验证码，出错直接返回
        if(!checkCode.equalsIgnoreCase(imgcode)){
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


    protected boolean exists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1：设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //2:获取页面参数（返回值为string类型 其他涉及到的类型需要转换）
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        User user= userService.exists(new User(username));
        //boolean flag ;
        if(user !=null){
            response.getWriter().write("您输入的用户名已经被使用，请重新输入");
            return true;
       }else {
            response.getWriter().write("您输入的用户名可以使用，请注册");
            return false;
        }
    }
}
