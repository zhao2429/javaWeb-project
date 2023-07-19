package com.project.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/3 14:48
 **/
//老师表
public class Teacher {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String project;
    private String grade;

    public Teacher() {
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Teacher(Integer id, String username, String password, Integer age, String project, String grade) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.project = project;
        this.grade = grade;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", project='" + project + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
