package com.project.dao.impl;

import com.project.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/3 14:55
 **/
public class BaseDao {
    //所有操作的方法都需要使用到QueryRunner
    private QueryRunner queryRunner = new QueryRunner();
    //每个操作需要自己的连接  只能定义变量 操作里获取连接
    private Connection connection = null;


    //通用增加  删除   修改

    /**
     * 通用 增删改的方法
     * @param sql 要执行的sql
     * @param args 可变形参 sql的问号参数
     * @return 执行后的受影响行数
     */
    public int update(String sql,Object... args){
        try {
            connection= JDBCUtils.getConn();//连接
            return  queryRunner.update(connection, sql,args);//执行并返回结果
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);//关闭资源
        }
        return -1;//出现异常返回-1
    }

    //通用查询对象单个

    /**
     * 通用的查询单个对象的方法
     * @param clazz 处理器需要的某对象的字节码文件
     * @param sql 需要执行的sql
     * @param args sql问号中的参数 可变形参
     * @param <T> 泛型 指定传入的class类型  返回值就是T类型 如Dog  返回就是Dog
     * @return
     */
    public <T>T selectForOne(Class<T> clazz,String sql,Object... args){
        try {
            connection = JDBCUtils.getConn();
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }

        return null;
    }

    //通用查询集合

    /**
     * 通用的查询集合的方法
     * @param clazz 查询后的类的字节码文件
     * @param sql 执行的sql语句
     * @param args 问号的参数
     * @param <T>  泛型 指定是传入的字节码文件是哪个类型 同时确定返回值的类型
     * @return 查询后的list集合
     */
    public <T> List<T> selectForList(Class<T> clazz, String sql, Object... args){
        try {
            connection = JDBCUtils.getConn();
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return null;
    }


    //通用查询单个值

    /**
     * 查询单个值的方法 通常是聚合函数
     * @param sql 执行的sql
     * @param args sql的参数
     * @return 返回查询的的结果  可能需要转换
     */
    public Object selectForValue(String sql,Object... args){
        try {
            connection  = JDBCUtils.getConn();
            return queryRunner.query(connection,sql, new ScalarHandler<>(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }

        return null;
    }


}
