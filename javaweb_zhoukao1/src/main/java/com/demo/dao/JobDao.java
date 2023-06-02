package com.demo.dao;

import com.demo.entity.Job;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/27 9:33
 **/
public interface JobDao {
    /**
     * 新增员工的方法
     * @param job  需要新增的员工数据
     * @return 受影响行数
     */
    int insertJob(Job job);

    /**
     * 删除员工的方法
     * @param job  需要新增的员工数据
     * @return 受影响行数
     */
    int deleteJob(Job job);

    /**
     * 修改员工的方法
     * @param job  需要新增的员工数据
     * @return 受影响行数
     */
    int updateJob(Job job);

    /**
     * 根据用户名和密码查询用户信息(登录)
     * @param job  查询时传入的条件对象
     * @return  查询后用户的对象信息
     */
    Job selectByUserAndPassWord(Job job);

    /**
     * 根据id查询员工信息
     * @param job 需要查询的员工对象
     * @return 查询后的员工完整信息
     */
    Job selectById(Job job);

    /**
     * 查询全部的员工信息
     * @return 查询到的员工集合的信息
     */
    List<Job> selectByList();

    /**
     * 模糊查询的方法
     * @param job
     * @return
     */
    List<Job> selectJobName(Job job);
}
