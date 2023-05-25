package ajax.demo_fanshe.test;

import ajax.demo_fanshe.entity.Student;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/18 18:46
 **/
public class TestOne {
    //没有反射之前如何创建对象和获取对象中的属性和方法
    public static void main(String[] args) {
        //创建对象
        Student stu=new Student();
        //访问属性
        //公开的
        stu.id=1;
        System.out.println(stu.id);
        //私有属性
        System.out.println(stu.getName());
        stu.setName("张三");
        stu.sleep();

        //私有方法无法访问
        //stu.say();
    }
}
