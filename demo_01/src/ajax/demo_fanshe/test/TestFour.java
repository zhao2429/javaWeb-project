package ajax.demo_fanshe.test;

import java.lang.reflect.Field;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/18 19:15
 **/
//反射获取成员变量
public class TestFour {
    public static void main(String[] args) throws Exception{
        //获取字节码文件
        Class c=Class.forName("ajax.demo_fanshe.entity.Student");
        //获取所有公开的成员变量数组
        Field[] fields = c.getFields();
        for (Field f:fields) {
            System.out.println("f = " + f);
        }
        System.out.println("--------------------------------------------");
        //获取所有的成员变量，公开的和私有的
        Field[] de = c.getDeclaredFields();
        for (Field f:de) {
            System.out.println("f = " + f);
        }
        System.out.println("--------------------------------------------");
        //3.获取单个公开的成员变量
        //获取公开的id，如果属性不存在将会报异常
        Field id = c.getField("id");
        System.out.println("id = " + id);
        System.out.println("--------------------------------------------");
        //4:获取单个的成员变量
        Field name = c.getDeclaredField("name");
        System.out.println("name = " + name);
    }
}
