package ajax.mvc.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/25 18:41
 **/
public class Dog {
    private  Integer id;
    private  String name;
    private  int age;
    private  String sex;

    private  Integer typeId;

    private Type type;

    public Dog() {
    }
    public Dog(Integer id) {
        this.id = id;
    }

    public Dog(Integer id, String name, int age, String sex, Integer typeId, Type type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.typeId = typeId;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", typeId=" + typeId +
                ", type=" + type +
                '}';
    }
}
