package ajax.demo.web; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 15:14
 **/

import ajax.demo.entity.User;
import ajax.demo.service.UserService;
import ajax.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

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
        //2:获取页面参数
        String username = request.getParameter("username");
        //3：将参数封装作为对象
        User user = new User(username);

        //4：调用方法
        List<User> list = userService.find(user);

        //5:判断查询结果
        if (list!=null){
          response.getWriter().write(list.toString());

        }else {
            System.out.println("暂时没有查询到信息！");
        }

    }
}
