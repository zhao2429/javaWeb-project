package com.project.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/31 9:13
 **/
public class Student {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String phone;
    private Integer status;


    public Student() {
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(String username, String password, Integer age, String phone, Integer status) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.status = status;
    }

    public Student(Integer id, String username, String password, Integer age, String phone, Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
