package com.demo.entity;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/27 9:30
 **/
public class Job {
    private Integer id;
    private String username;
    private String password;
    private String jobs;
    private String phone;

    public Job() {
    }

    public Job(Integer id) {
        this.id = id;
    }

    public Job(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Job(String username, String password, String jobs, String phone) {
        this.username = username;
        this.password = password;
        this.jobs = jobs;
        this.phone = phone;
    }

    public Job(Integer id, String username, String password, String jobs, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.jobs = jobs;
        this.phone = phone;
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

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jobs='" + jobs + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
