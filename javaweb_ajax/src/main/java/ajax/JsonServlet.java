package ajax; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/17 15:27
 **/

import com.alibaba.fastjson.JSON;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jsonServlet")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //此时post请求以后过来的是请求体的方式
        BufferedReader reader = request.getReader();
        //获取到请求的字符串
        String s = reader.readLine();
        //在java中需要使用java对象来进行操作，需要将字符串转为java对象
        User user = JSON.parseObject(s, User.class);
        System.out.println("user = " + user);

        //使用该对象可以调用service方法
        System.out.println("=================================================");
        //模拟查询到单个对象的集合，响应到客户端,,这里的话需要java对象转为字符串

        String s1 = JSON.toJSONString(user);
        //设置响应类型
        response.setContentType("application/json;charset=UTF-8");
        //response.setContentType("text/json;charset=UTF-8");
        //将字符串响应给客户端
        //response.getWriter().write(s1);

        //响应一个集合到客户端
        List<User> list = new ArrayList<>();
        list.add(new User(1,"张三",15));
        list.add(new User(2,"李四",20));
        list.add(new User(3,"王五",30));
        list.add(new User(4,"麻子",25));
        String s2 = JSON.toJSONString(list);
        response.getWriter().write(s2);
    }
}
