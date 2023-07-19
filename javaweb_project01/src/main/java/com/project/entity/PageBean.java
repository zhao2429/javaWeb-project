package com.project.entity;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/3 14:53
 **/
//分页查询时需要一个list数据又需要一个count总数的对象 ，可以选择自定义
public class PageBean<T>{
    private List<T> list; //查询到的数据
    private  Integer count; //获取到的总条数

    public PageBean() {
    }

    public PageBean(List<T> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
