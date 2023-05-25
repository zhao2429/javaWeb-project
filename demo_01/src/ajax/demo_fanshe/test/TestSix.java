package ajax.demo_fanshe.test;

import ajax.demo_fanshe.entity.Student;

import java.lang.reflect.Method;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/18 19:15
 **/
//反射获取
public class TestSix {
    public static void main(String[] args) throws Exception{
        //获取字节码文件
        Class c=Class.forName("ajax.demo_fanshe.entity.Student");
        //获得类的方法
        //获取类的public方法（包含了父类继承 的public方法）
        Method[] m = c.getMethods();
        for (Method me:m) {
            System.out.println("me = " + me);
        }
        System.out.println("--------------------------------------------");
        //2：获取所有类的方法（公开，私有）不包含继承的
        Method[] de = c.getDeclaredMethods();
        for (Method method:de) {
            System.out.println("method = " + method);
        }
        System.out.println("--------------------------------------------");
        //获取某个公开的方法(空参)
        Method sleep = c.getMethod("sleep");
        System.out.println("slepp = " + sleep);
        //获取某个公有的方法（有参）
        Method eat= c.getMethod("eat",String.class);
        System.out.println("eat = " + eat);

        //创建对象
        Student stu=new Student();
        //调用方法(空参)
        Object invoke = sleep.invoke(stu);
        System.out.println("invoke = " + invoke);
        //有参
        String s = (String) eat.invoke(stu,"米线");
        System.out.println("s = " + s);
        //私有属性
        Method say = c.getDeclaredMethod("say", String.class);
        //修改权限
        say.setAccessible(true);
        //调用
        String x = (String) say.invoke(stu, "小明");
        System.out.println("x = " + x);

    }
}
