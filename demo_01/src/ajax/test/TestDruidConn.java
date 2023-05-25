package ajax.test;

import ajax.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/19 19:47
 **/
public class TestDruidConn {
    public static void main(String[] args) {
        //获取连接
        Connection con = JdbcUtils.getCon();
        System.out.println("con = " + con);
        //关闭
        JdbcUtils.closes(con,null,null);
    }
}
