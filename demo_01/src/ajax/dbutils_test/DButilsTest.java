package ajax.dbutils_test;

import ajax.entity.Dog;
import ajax.entity.DogTwo;
import ajax.entity.Type;
import ajax.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/23 10:35
 **/
//演示DButils进行CRUD操作
public class DButilsTest {
    //新增
    @Test
    public void add() throws SQLException {
        //1:获取执行sql的对象
        QueryRunner runner = new QueryRunner();

        //获取连接
        Connection con = JdbcUtils.getCon();

        //定义sql
        String sql = "insert into dog values(?,?,?,?)";

        //2：执行sql
        int update = runner.update(con, sql, null, "小紫", 5, "母");
        System.out.println("您添加了： " + update+"条数据");

        //DButils 关闭链接
        DbUtils.closeQuietly(con);
    }

    //执行删除操作
    @Test
    public void remove() throws SQLException {
        //1：获取执行sql的对象
        QueryRunner runner = new QueryRunner();
        //获取数据库连接
        Connection con = JdbcUtils.getCon();
        //定义sql
        String sql = "delete from dog where = ?";
        //2：执行sql
        int update = runner.update(con, sql, 8);
        System.out.println("您删除了 " + update+"条数据");
        //3：关闭资源
        DbUtils.closeQuietly(con);
    }

    //执行修改操作
    @Test
    public void revise() throws SQLException {
        //1：获取执行sql的对象
        QueryRunner runner = new QueryRunner();
        //获取数据库连接
        Connection con = JdbcUtils.getCon();
        //定义sql
        String sql = "update dog set name = ? , age = ? , sex = ?  where id = ?";
        //2：执行sql
        int update = runner.update(con, sql, "大黄",2,"公",8);
        System.out.println("您修改了 " + update+"条数据");
        //3：关闭资源
        DbUtils.closeQuietly(con);
    }

    //查询单个数据  ，一条数据
    //根据id查询dog信息
    @Test
    public void selectById() throws SQLException {
        QueryRunner runner=new QueryRunner();

        Connection con = JdbcUtils.getCon();

        String sql = "select * from dog where id= ?";
        //创建一个单个对象结果集的处理器
        BeanHandler<Dog> handler = new BeanHandler<>(Dog.class);
        Dog dog= runner.query(con, sql,handler, 8);
        System.out.println("单个数据为：" + dog);
        DbUtils.closeQuietly(con);
    }

    //查询集合 所有数据
    @Test
    public void selectAll() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection con = JdbcUtils.getCon();
        String sql = "select * from dog";
        //创建多个对象结果集的处理器
        BeanListHandler<Dog> handler = new BeanListHandler<>(Dog.class);
        List<Dog> dog= runner.query(con, sql,handler);
        System.out.println("数据为：" + dog);
        DbUtils.closeQuietly(con);
    }

    //查询单个值， max。min，sum,count,avg等
    @Test
    public void selectByValue() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection con = JdbcUtils.getCon();
        String sql = "select max(age) from dog where id < ?";
        //创建查询单值的结果处理器
        ScalarHandler handler=new ScalarHandler();
        Object query = runner.query(con,sql,handler,8);
        
        //object  ==> int 
        Number number = (Number) query;
        int i =number.intValue();
        System.out.println("i = " + i);
        DbUtils.closeQuietly(con);
    }

    //查询Dog的id= 1的信息和他所属的类型名称
    @Test
    public void selectByIdAndType() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection con = JdbcUtils.getCon();
        String sql = "select d.* ,t.`typename` from `dog` d left join `type` t on d.typeid = t. typeid where id = ? ";
        //根据查询到的列名给实体的属性赋值
        //BeanHandler<Dog> handler= new BeanHandler<>(Dog.class);

        //采用自定义的处理器
        DogHandler<DogTwo> handler = new DogHandler<>();

        DogTwo dog = runner.query(con, sql, handler, 1);
        System.out.println("dog = " + dog);
        System.out.println("名字为："+dog.getName()+"\n"+"类别为："+dog.getType().getTypeName());
        DbUtils.closeQuietly(con);
    }


    //匿名实现类；通常情况下，我们可以直接写一个 实现抽象方法
    //匿名实现类就是这个类，不需要定义出来直接写
    @Test
    public void selectByIdAndType01() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection con = JdbcUtils.getCon();
        String sql = "select d.* ,t.`typename` from `dog` d left join `type` t on d.typeid = t. typeid where id = ? ";

        //采用匿名实现类作为处理器
        ResultSetHandler<DogTwo> handler = new ResultSetHandler<DogTwo>() {
            //实现处理器的方法
            @Override
            public DogTwo handle(ResultSet resultSet) throws SQLException {
                DogTwo dog = null;
                //手动处理查询到的结果
                if (resultSet.next()){
                    dog = new DogTwo();
                    //获取到dog的信息进行赋值
                    dog.setId(resultSet.getInt(1));
                    dog.setName(resultSet.getString(2));
                    dog.setAge(resultSet.getInt(3));
                    dog.setSex(resultSet.getString(4));

                    //类型相关的东西
                    Type type = new Type();
                    type.setTypeId(resultSet.getInt(5));
                    type.setTypeName(resultSet.getString(6));
                    //将type对象赋值给dog的type属性；
                    dog.setType(type);
                }
                return  dog;
            }
        };
        DogTwo dog = runner.query(con, sql, handler, 1);
        System.out.println("dog = " + dog);
        System.out.println("名字为："+dog.getName()+"\n"+"类别为："+dog.getType().getTypeName());
        DbUtils.closeQuietly(con);
    }

}
