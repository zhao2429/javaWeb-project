package ajax.loginregister.filter; /**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/13 16:43
 **/

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest)request;

        //登录过滤的拦截器，如果没有登录不允许进入首页或者其他后台页面
        //会进行拦截一部分页面，需要条件，但是也会放行一些请求

        //定义好不需要拦截直接可以访问的路径
        String[] urls = {"/imgs/","/css/","/js/","/user/","/code.jpg","/register.jsp"};

        //查看当前请求路径
        String url = request1.getRequestURL().toString();
        //对比数组是否需要直接放行
        for(String s :urls){
            //对比路径中是否有需要放行的路径
            if(url.contains(s)){
                //在数组中找到和请求路径中相同的字符串
                chain.doFilter(request,response);
                return;
            }
        }
        //不需要进行放行又怎么处理,不能直接放行，需要判断是否满足条件
        //代表需要访问未登录不能访问的资源

        //获取登录存储的值,从登录后储存的session中获取
        Object loginuser = request1.getSession().getAttribute("loginUser");


        //判断有没有值
        if (loginuser !=null){
            //有值  访问
            chain.doFilter(request,response);
        }else {
            // //无值跳转，或响应未登录的结果
            request1.setAttribute("login_msg","您尚未登录请进行登录！！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        //有值就进行访问

        chain.doFilter(request, response);
    }
}
