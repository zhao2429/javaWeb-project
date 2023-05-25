package ajax.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/17 18:47
 **/
//连接mysql
public class TestJdbc {
    public static void main(String[] args) throws Exception{
        //1.注册数据库的驱动
        //也可以写成
        //Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2.通过DriverManager获取数据库连接
        String url="jdbc:mysql://localhost:3306/exam";
        String username="root";
        String password="123456";
        Connection connection=DriverManager.getConnection(url,username,password);
        //3.通过Connection对象获取Statement对象
        Statement statement= connection.createStatement();
        //4.使用Statement对象执行sql语句
        String sql="select * from Student";
        ResultSet rs=statement.executeQuery(sql);
        //5、操作 ResultSet结果集
        System.out.println("Sid|Sname|Sage|Ssex");
        while (rs.next()) {
            //通过列名获取指定字段的值
            String id=rs.getString("Sid");
            String name=rs.getString("Sname");
            String age=rs.getString("Sage");
            String sex=rs.getString("Ssex");
            System.out.println(id+"|"+name+"|"+age+"|"+sex);
        }
        //6.关闭链接，释放资源
        if(rs!=null){
            try{
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(statement!=null){
            try{
                statement.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
                connection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
