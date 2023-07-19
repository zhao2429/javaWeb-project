package com.project.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 15:28
 **/
public class Score {
    private Integer id;
    private String username;
    private String grade;
    private String projectname;
    private String fraction;

    public Score() {
    }

    public Score(Integer id) {
        this.id = id;
    }

    public Score(Integer id, String username, String grade, String projectname, String fraction) {
        this.id = id;
        this.username = username;
        this.grade = grade;
        this.projectname = projectname;
        this.fraction = fraction;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", grade='" + grade + '\'' +
                ", projectname='" + projectname + '\'' +
                ", fraction='" + fraction + '\'' +
                '}';
    }
}
