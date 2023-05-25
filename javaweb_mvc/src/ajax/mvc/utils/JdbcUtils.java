package ajax.mvc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/19 19:33
 **/
//定义打开和关闭数据库连接的方法
public class JdbcUtils {
    private static DataSource dataSource=null;
    //静态代码块，只要类加载代码就会被被执行
    static {
        try {
        //1.创建properties
        Properties properties=new Properties();
        //2.从配置文件中读取流
        properties.load(
                JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties")
        );
        //3.获取数据源
           dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获得数据库连接
    public static Connection getCon(){
        //正常运行返回连接
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 出现异常返回空
        return  null;
    }

    //关闭数据库连接
    public static void closes(Connection connection, PreparedStatement statement, ResultSet rs){
        //后开，先关
        try {
            if (rs!=null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                    connection.close();
                }
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
