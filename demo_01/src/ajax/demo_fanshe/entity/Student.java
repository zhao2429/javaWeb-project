package ajax.demo_fanshe.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/18 18:37
 **/
// 实体，存储信息
public class Student {
    public int id;
    private String name;
    private int age;
    // 构造方法 get/set  tostring


    public Student() {
    }
    //私有构造函数
    private Student(String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //定义普通的方法
    public void sleep(){
        System.out.println("学生正在睡觉");
    }
    public String eat(String food){
        return  "吃"+food;
    }
    private  String say(String hu){
        System.out.println("学生在打招呼");
        return hu;
    }
}
