import ajax.login.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/9 10:58
 **/
public class ConnTest {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConn();
        System.out.println("connection = " + connection);
    }
}
