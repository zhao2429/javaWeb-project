package ajax.servlet01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 11:20
 **/
//实现servlet的接口
//表示当浏览器发起请求地址为  当前项目下/hello，此servlet会被访问且执行service的方法

//    loadOnStartup设置servlet的创建时机
//    负整数：第一次创建；；0或者正整数：是服务器启动的时候创建，多个servlet都设置，值越小优先级越高
@WebServlet(urlPatterns = "/hello03" , loadOnStartup = 1)
public class HelloServletThree implements Servlet {
/*1:执行servlet构造方法创建对象*/
    public HelloServletThree(){
        System.out.println("1：构造函数创建对象");
    }

    /*2：初始化对象 ，加载一下配置信息*/
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2：初始化信息");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用于处理请求和响应
     * @param servletRequest 请求对象
     * @param servletResponse 响应对象
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3:处理请求响应结果!");
    }

    //专门获取servlet信息
    @Override
    public String getServletInfo() {
        return null;
    }


    /*4：销毁对象*/
    @Override
    public void destroy() {
        System.out.println("4：servlet被销毁");
    }
}
