package com.ajaxdemo;

import com.ajaxdemo.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/17 16:22
 **/
public class ConnTest {
    public static void main(String[] args) {
        Connection con = JDBCUtils.getConn();
        System.out.println("con = " + con);
    }
}
