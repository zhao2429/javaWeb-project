package ajax.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/13 16:15
 **/

//@WebFilter("/*")
public class Filter01 implements Filter {
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    /*做过滤器的功能*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是filter，我处理拦截！");
        //通常在这里对请求和响应做一些操作和判断
        System.out.println("放行前");
        //处理完后可以方行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后");
    }

    //销毁
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
