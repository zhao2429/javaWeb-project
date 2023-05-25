package ajax.test;

import ajax.demo.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/4 10:35
 **/
public class JDBCTest {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConn();
        System.out.println("connection = " + connection);
    }
}
