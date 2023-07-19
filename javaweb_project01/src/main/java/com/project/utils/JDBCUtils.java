package com.project.utils;

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
 * @DateTime: 2023/6/3 10:29
 **/
public class JDBCUtils {
    /**
     * 获取数据库连接
     * @return
     */

    private static DataSource dataSource=null;
    static {
        //加载德鲁伊的资源
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        try {
            return dataSource.getConnection();
        } catch (Exception e){
            e.printStackTrace();
        }

        //异常返回
        return  null;
    }


    /**
     * 关闭资源
     */
    public static  void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if (connection!=null){
                connection.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
