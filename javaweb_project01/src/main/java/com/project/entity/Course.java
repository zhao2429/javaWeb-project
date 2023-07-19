package com.project.entity;

import java.sql.Timestamp;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 8:55
 **/
public class Course {
    private Integer id;
    private String teachername;
    private String workname;
    private Timestamp  starttime;
    private Timestamp  endtime;
    private String homework;
    private String image;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(String image) {
        this.image = image;
    }

    public Course(String teachername, String workname, Timestamp starttime, Timestamp endtime, String homework) {
        this.teachername = teachername;
        this.workname = workname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.homework = homework;
    }

    public Course(Integer id, String teachername, String workname, Timestamp starttime, Timestamp endtime, String homework) {
        this.id = id;
        this.teachername = teachername;
        this.workname = workname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.homework = homework;
    }

    public Course(Integer id, String teachername, String workname, Timestamp starttime, Timestamp endtime, String homework, String image) {
        this.id = id;
        this.teachername = teachername;
        this.workname = workname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.homework = homework;
        this.image = image;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", teachername='" + teachername + '\'' +
                ", workname='" + workname + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", homework='" + homework + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
