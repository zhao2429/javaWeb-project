package ajax.crud.test;

import ajax.crud.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 10:12
 **/
public class ConnTest {
    public static void main(String[] args) {
        Connection con = JDBCUtils.getConn();
        System.out.println("con = " + con);
    }
}
