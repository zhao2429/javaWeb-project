package ajax.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/13 16:15
 **/

@WebFilter("/*")
public class FilterB implements Filter {

    /*做过滤器的功能*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("1：B过滤器前操作");
        //通常在这里对请求和响应做一些操作和判断
        //处理完后可以方行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("2：B过滤器后操作");
    }

}
