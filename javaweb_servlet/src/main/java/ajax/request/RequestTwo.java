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
import java.util.Map;

@WebServlet("/test02")
public class RequestTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用dopost处理
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码为UTF-8
        request.setCharacterEncoding("UTF-8");

        //通用的获取请求参数
        //1：获取所有的参数map集合
        Map<String, String[]> map = request.getParameterMap();
        //循环取值
        for (String key: map.keySet()){
            //获取map的key
            System.out.println("key = " + key);
            //根据map的key获取value
            String[] strings = map.get(key);
            //将值遍历出来
            for (String value : strings){
                System.out.println("value = " + value);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        //2:根据参数的名称获取值的数组
        System.out.println("==========================================");
        //获取爱好的多个属性作为数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies){
            System.out.println("hobby = " + hobby);
        }

        //3：根据参数名称获取参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
