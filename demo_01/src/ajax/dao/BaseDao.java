package ajax.dao;

import ajax.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/24 20:04
 **/
//BaseDao将作为后续Dao层（数据增删改操作）的一个基本的类
//功能： 定义针对增删改通用的方法 与 查询通用的方法
public class BaseDao {
    //所有的操作的方法都需使用到QueryRunner
    private QueryRunner runner = new QueryRunner();
    private  Connection con = null;
    //通用增加，删除，修改

    /**
     * 通用的增删改方法
     * @param sql 要执行的sql
     * @param args 可变形参sql的问号参数
     * @return 执行后的受影响的行数
     */
    public int update(String sql , Object... args){
        try {
            con = JdbcUtils.getCon(); //连接
            return  runner.update(con,sql,args);//执行并返回的结果
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con); //关闭资源
        }
        return  -1; // 出现异常返回 -1
    }


    //通用查询单个

    /**
     * 查询通用的单个对象的方法
     * @param clazz 处理器需要的某对象的字节码文件
     * @param sql 需要执行的sql
     * @param args sql问号中的参数 可变形参
     * @return
     * @param <T>  泛型，指定传入的class的类型，返回值就是T类型  如Dog 返回的就是Dog
     */
    public <T>T selectByOne(Class<T> clazz ,String sql , Object... args){
        try {
            con = JdbcUtils.getCon();
            return runner.query(con,sql,new BeanHandler<>(clazz),args);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return null;
    }


    //通用查询集合
    /**
     * 查询通用的集合的方法
     * @param clazz 处理器需要的某对象的字节码文件
     * @param sql 需要执行的sql
     * @param args sql问号中的参数 可变形参
     * @return
     * @param <T>  泛型，指定传入的class的类型，返回值就是T类型  如Dog 返回的就是Dog
     */
    public <T> List<T> selectList(Class<T> clazz, String sql , Object... args){
        try {
            con = JdbcUtils.getCon();
            return runner.query(con,sql,new BeanListHandler<>(clazz),args);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return  null;
    }



    //通用查询单个值

    /**
     * 查询单个值的方法，通常是聚合函数
     * @param sql 执行的sql
     * @param args sql的参数
     * @return 返回查询的结果， 可能需要转换
     */
    public Object selectForValue(String sql , Object... args){
        try {
            con = JdbcUtils.getCon();
            return  runner.query(con,sql,new ScalarHandler<>(),args);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return  null;
    }
}
