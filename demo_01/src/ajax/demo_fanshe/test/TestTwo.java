package ajax.demo_fanshe.test;

import ajax.demo_fanshe.entity.Student;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/18 18:56
 **/
//反射 获取类的class的字节码对象
public class TestTwo {

    public static void main(String[] args) throws ClassNotFoundException {
        //通过calss类的静态方法加载student类的字节码文件
        //将student加载到内存中java编译成class，加载进去就是字节码文件
        Class c=Class.forName("ajax.demo_fanshe.entity.Student");
        System.out.println(c);

        //2：通过类的class属性获取字节码对象
        Class cl= Student.class;
        System.out.println("clazz2"+cl);

        //3:通过对象的getClass来获取字节码文件
        Student stu=new Student();
        Class cla=stu.getClass();
        System.out.println("claszz3"+cla);


        //通过字节码文件。后期可以其中的属性，方法，构造函数等进行操作；

    }

}
