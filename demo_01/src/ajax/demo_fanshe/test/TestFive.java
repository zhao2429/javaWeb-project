package ajax.demo_fanshe.test;

import ajax.demo_fanshe.entity.Student;

import java.lang.reflect.Field;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/18 19:15
 **/
//反射获取
public class TestFive {
    public static void main(String[] args) throws Exception{
        //获取字节码文件
        Class c=Class.forName("ajax.demo_fanshe.entity.Student");
        //创建一个student的对象
        Student stu=new Student(1,"张三",25);
        //获取name属性
        Field name = c.getDeclaredField("name");
        //修改临时权限(就算私有的也可以访问)
        name.setAccessible(true);
        //通过name属性进行赋值(赋值为那个对象，值为什么)
        name.set(stu,"王五");
        System.out.println(stu);
        //通过反射获取name的值
       String s  = (String) name.get(stu);
        System.out.println("name = " + s);
    }
}
