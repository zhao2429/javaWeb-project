package ajax.demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/19 10:11
 **/
public class TestJdbcTwo {
    public static void main(String[] args) throws Exception{
        //从文件中读取
        //1:从系统类加载的形式读取文件的流，普通的java的项目可以使用
        //InputStream in=ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        //2：使用当前的类的字节码文件来读取文件（推荐web使用）
        InputStream in = TestJdbcTwo.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //从流中把数据读取出来
        Properties p=new Properties();     //读取最终为properties
        p.load(in);//读取流放入p对象
        //先去初始化一些信息，从文件中读取key获取vaule
        String driver=p.getProperty("driverClass");
        String url=p.getProperty("url");
        String username=p.getProperty("user");
        String password=p.getProperty("password");

        //注册jdbc驱动
        Class.forName(driver);
        //2.通过DriverManager获取数据库连接
        Connection connection= DriverManager.getConnection(url,username,password);
        //输出对象
        System.out.println("connection = " + connection);
        if (connection == null){
            System.out.println("获取连接失败！");
        }else {
            System.out.println("获取连接成功！");
        }

        //关闭链接
        connection.close();
    }
}
