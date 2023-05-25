package ajax.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/4/24 19:14
 **/
public class DogTwo {
    private  Integer id;
    private  String name;
    private  int age;
    private  String sex;

    private  int typeId;

    private Type type;

    public DogTwo() {
    }

    public DogTwo(String name, int age, String sex, int typeId, Type type) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.typeId = typeId;
        this.type = type;
    }

    public DogTwo(Integer id, String name, int age, String sex, int typeId, Type type) {
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DogTwo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", typeId=" + typeId +
                ", type=" + type +
                '}';
    }
}
