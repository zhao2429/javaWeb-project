package com.project.entity;

import java.sql.Timestamp;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 10:56
 **/
public class Leave {
    private Integer id;
    private String username;
    private String grade;
    private String days;
    private Timestamp time;
    private String cause;

    public Leave() {
    }

    public Leave(Integer id) {
        this.id = id;
    }

    public Leave(Integer id, String username, String grade, String days, Timestamp time, String cause) {
        this.id = id;
        this.username = username;
        this.grade = grade;
        this.days = days;
        this.time = time;
        this.cause = cause;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", grade='" + grade + '\'' +
                ", days='" + days + '\'' +
                ", time=" + time +
                ", cause='" + cause + '\'' +
                '}';
    }
}
