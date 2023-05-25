package ajax.cookie; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/10 15:14
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie02")
public class CookieServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //尝试获取cookie
        Cookie[] cookies = request.getCookies();
        //循环找到需要的cookie
        for (Cookie cook:cookies) {
            String name = cook.getName();
            //判断找出我们存储的cookie,名字比对
            if("username".equals(name)){
                //找到就根据键拿取值
                String value = cook.getValue();
                System.out.println("value = " + value);
                break;
            }
            }

        }
    }

