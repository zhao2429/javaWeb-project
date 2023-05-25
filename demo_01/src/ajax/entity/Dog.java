package ajax.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/19 20:07
 **/

/**、
 * 表和java的关系
 * 一个表对应着一个java的类（实体）
 *一个表中的字段对应java的属性
 * 一个表的一条记录对应着java类的一个new的对象
 */
public class Dog {
    //属性
    private  Integer id;
    private  String name;
    private  int age;
    private  String sex;

   //private  int typeId;

    //构造方法 get set  toString

    public Dog() {
    }

    public Dog(Integer id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
