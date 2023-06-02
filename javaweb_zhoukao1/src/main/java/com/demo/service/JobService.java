package com.demo.service;

import com.demo.entity.Job;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/27 9:55
 **/
public interface JobService {
    //新增
    boolean add(Job job);
    //删除
    boolean remove(Job job);
    //修改
    boolean modify(Job job);
    //根据id查询
    Job findById(Job job);

    /**
     * 业务层登录的方法
     * @param job  需要验证的用户信息
     * @return   返回查询后的用户信息
     */
    Job login(Job job);
    //查询全部
    List<Job> findByAll();

    //模糊查询
    List<Job> find(Job job);
}
