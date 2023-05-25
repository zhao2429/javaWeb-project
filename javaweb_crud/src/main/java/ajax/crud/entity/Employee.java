package ajax.crud.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/8 9:24
 **/
public class Employee {
    private Integer id;
    private  String userName;
    private String passWord;
    private  Integer age;
    private  String phone;
    private  Integer status;

    public Employee() {
    }



    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(String userName, String passWord, Integer age, String phone, Integer status) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.phone = phone;
        this.status = status;
    }

    public Employee(Integer id, String userName, String passWord, Integer age, String phone, Integer status) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.phone = phone;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
