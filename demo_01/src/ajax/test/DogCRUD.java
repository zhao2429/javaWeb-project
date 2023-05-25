package ajax.test;

import ajax.entity.Dog;
import ajax.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/19 20:16
 **/
public class DogCRUD {
    //定义成员变量
    private Connection con=null;
    private PreparedStatement ps=null;
    private  ResultSet rs=null;

    /*测试新增的方法*/
    @Test
    public void add() throws Exception {
        //1:获取数据库连接
        con = JdbcUtils.getCon();
        //2：定义执行的sql
        String sql="insert into dog values(?,?,?,?)";
        //3：获取执行sql的对象
        //使用此方式是表示sql参数是拼接进去的，一些特殊的值会导致sql存在注入的问题
        //Statement statement = con.createStatement();
        //将sql进行预编译然后得到执行对象，为sql传值通过？问号的形式进行赋值
        ps=con.prepareStatement(sql);
        //为预编译的sql赋值,参数索引从1开始
        ps.setInt(1,0);
        ps.setString(2,"测试");
        ps.setInt(3,2);
        ps.setString(4,"公");
        //4：执行sql
        int i= ps.executeUpdate();
        //5：处理执行结果
        System.out.println("i = " + i);
        //6：关闭资源
        JdbcUtils.closes(con,ps,null);
    }

    //测试删除的方法
    @Test
    public void remove() throws Exception{
        //1:打开连接
        con=JdbcUtils.getCon();
        //2：书写sql语句
        String sql="delete from dog where id=?";
        //3：获取执行sql对象
        ps=con.prepareStatement(sql);
        //4：为预编译？进行赋值
        ps.setInt(1,6);
        //5：执行sql语句
        int row = ps.executeUpdate();
        //6：返回结果
        System.out.println("row = " + row);
        //7:关闭资源
        JdbcUtils.closes(con,ps,null);
    }

    //测试修改的方法
    @Test
    public void modify(){
        //模拟一个传进来的参数
        Dog dog = new Dog(6,"新的名字",1,"公");

        try {
            con = JdbcUtils.getCon();
            String sql = "update dog set name = ?,age = ?,sex = ? where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,dog.getName());
            ps.setInt(2,dog.getAge());
            ps.setString(3,dog.getSex());
            ps.setInt(4,dog.getId());
            int i = ps.executeUpdate();
            System.out.println("i = " + i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closes(con,ps,null);
        }


    }

    //测试根据id来查询数据
    //测试根据id查询一条数据
    @Test
    public void selectById(){

        try {
            con = JdbcUtils.getCon();
            String sql = "select * from dog where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,1);
            //结果集 查询到的一个虚拟的表 可能有值可能没有值 需要手动取出值
            rs = ps.executeQuery();

            //判断 next()：1.光标下移 2.判断下移后指向的行有无数据 有true 无false
            if(rs.next()){
                //取值  1.通过列名取值  2.通过数据的索引取值

                //1.通过列名取值
                int id = rs.getInt("id");//id
                String name = rs.getString("name");//name
                int age = rs.getInt("age");//age
                String sex = rs.getString("sex");//sex
                //将查询后的数据封装为对象
                Dog dog = new Dog(id,name,age,sex);
                System.out.println(dog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closes(con,ps,rs);
        }

    }

    //测试查询全部
    @Test
    public void selectByAll() {
        try {
            con= JdbcUtils.getCon();
            String sql = "select * from dog";
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            //查询全部结果集有多个行
            while (rs.next()){
                //循环取数据
                int id=rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                Dog dog=new Dog(id,name,age,sex);
                System.out.println("dog = " + dog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closes(con,ps,rs);
        }

    }

}



