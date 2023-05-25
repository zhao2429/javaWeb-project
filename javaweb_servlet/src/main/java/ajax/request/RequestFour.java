package ajax.request;
/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 15:39
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test04")
public class RequestFour extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用dopost处理
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        String money = request.getParameter("money");
        System.out.println("能否取到里面的值"+money);
        //获取请求参数（查看小票）
        Object xiao = request.getAttribute("小票");
        System.out.println("点餐的小票为： " + xiao);
        System.out.println("开始做猪脚饭！");

        //测试转发到别的资源
        //request.getRequestDispatcher("http://www.baidu.com").forward(request,response); 不可以跳转，只能在本目录下
        request.getRequestDispatcher("/index.jsp").forward(request,response); //webapp下面是可以
        //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response); //转发可以访问
    }
}
