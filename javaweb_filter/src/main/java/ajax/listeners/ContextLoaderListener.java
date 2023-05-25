package ajax.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/15 14:19
 **/

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /*ServletContext应用程序实例创建时自动执行的方法*/
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //在这加载需要的资源
        System.out.println("系统启动加载资源");
    }


    /*ServletContext应用程序实施销毁时自动执行的方法*/
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //在这释放资源
        System.out.println("系统释放停止资源");
    }
}
