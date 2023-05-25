package ajax.demo;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/19 19:00
 **/
public class TestDruid {
    public static void main(String[] args) throws Exception {
        //1.创建properties
        Properties properties=new Properties();
        //2.从配置文件中读取流
        properties.load(
                TestDruid.class.getClassLoader().getResourceAsStream("druid.properties")
        );
        //3.获取数据源
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
        //4.获取数据库连接
        Connection con=dataSource.getConnection();
        System.out.println("con = " + con);
        con.close();
    }
}
