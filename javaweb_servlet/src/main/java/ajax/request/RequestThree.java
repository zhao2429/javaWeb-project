package ajax.request;
/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 15:39
 **/

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//用于测试转发
@WebServlet("/test03")
public class RequestThree extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用dopost处理
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        //获取请求的参数（就相当于吃东西的钱）
        String money = request.getParameter("money");
        System.out.println("在窗口A（test03）查看参数（钱）" + money);

        //给小票，并且小票传递到窗口B（test04）查看,就需要存储票
        request.setAttribute("小票","猪脚饭17元");  //域对象

        //问路，怎么走，怎么领取猪脚饭
        RequestDispatcher path = request.getRequestDispatcher("/test04");// 窗口B

        //走向窗口B（/test04）
        path.forward(request,response);



    }
}
