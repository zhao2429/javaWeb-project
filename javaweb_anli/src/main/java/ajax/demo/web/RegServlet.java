package ajax.demo.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 14:28
 **/

import ajax.demo.entity.User;
import ajax.demo.service.UserService;
import ajax.demo.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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

        //3：封装为对象
        User user = new User(username,password);


        //4：调用service方法
        boolean falg = userService.reg(user);

        //5：得到结果，判断返回
        if (falg){
            //成功
            request.getRequestDispatcher("/login.html").forward(request,response);
        }else {
            //失败
            request.getRequestDispatcher("/zhuce.html").forward(request,response);
        }

    }
}
