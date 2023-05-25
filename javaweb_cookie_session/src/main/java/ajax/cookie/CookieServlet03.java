package ajax.cookie; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 15:28
 **/

import ajax.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cookie03")
public class CookieServlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //修改cookie
        //方案一：创建一个同名的cookie重新保存
        Cookie cookie = new Cookie("username","李华");
        response.addCookie(cookie);

        //方式二：获取所有的cookie，然后找到cookie使用setValue赋新的值然后通知客户端保存
        Cookie username = CookieUtils.findCookie(request.getCookies(), "username");
        if(username !=null){
            //修改cookie的值
            username.setValue("李四");
            response.addCookie(username);
            String name = username.getName();
            String value = username.getValue();
            System.out.println("name = " + name);
            System.out.println("value = " + value);
        }else {
            response.getWriter().write("您的cookie不存在！");
        }
    }
}
