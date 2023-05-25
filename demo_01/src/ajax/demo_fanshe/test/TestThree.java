package ajax.demo_fanshe.test;

import java.lang.reflect.Constructor;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/18 19:15
 **/
//反射获取构造方法
public class TestThree {
    public static void main(String[] args) throws Exception{
        //获取字节码文件
        Class c=Class.forName("ajax.demo_fanshe.entity.Student");

        //获取所有公开的构造方法
        Constructor[]  con=c.getConstructors();
        //遍历
        for (Constructor constructor:con) {
            System.out.println(constructor);
        }
        System.out.println("--------------------------------------------");
        //2:获取所有的构造方法（publcic private ）
        Constructor[] declaredConstructor=c.getDeclaredConstructors();
        //遍历
        for (Constructor constr:declaredConstructor) {
            System.out.println(constr);
        }
        System.out.println("--------------------------------------------");

        //3:获取公开的构造函数
        //空参函数
        Constructor cons=c.getConstructor();
        //三个参数的构造函数，参数需要执行参数的字节码文件
        Constructor con1 = c.getConstructor(int.class, String.class, int.class);
        System.out.println(cons);
        System.out.println(con1);
        System.out.println("--------------------------------------------");

        //获取构造方法，私有共有都可以
        Constructor con2=c.getDeclaredConstructor(String.class, int.class);
        System.out.println("con2 = " + con2);
        //获取了构造方法，我们需要调用构造方法才可以创建对象，调用需要使用指定方法；
    }
}
