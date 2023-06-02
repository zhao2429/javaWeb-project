package com.demo.dao.impl;

import com.demo.dao.JobDao;
import com.demo.entity.Job;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/27 9:48
 **/
public class JobDaoImpl extends BaseDao implements JobDao {
    @Override
    public int insertJob(Job job) {
        String sql = "insert into job values(?,?,?,?,?)";
        return update(sql,
                0,
                job.getUsername(),
                job.getPassword(),
                job.getJobs(),
                job.getPhone());

    }

    @Override
    public int deleteJob(Job job) {
        String sql = "delete from job where id = ?";
        return update(sql,job.getId());
    }

    @Override
    public int updateJob(Job job) {
        String sql = "update job set username = ?,password = ?,jobs = ?,phone = ? where id = ?";
        return update(sql,
                job.getUsername(),
                job.getPassword(),
                job.getJobs(),
                job.getPhone(),
                job.getId());
    }

    @Override
    public Job selectByUserAndPassWord(Job job) {
        String sql = "select * from job where username = ? and password = ? ";
        return selectForOne(Job.class,sql,job.getUsername(),job.getPassword());
    }

    @Override
    public Job selectById(Job job) {
        return null;
    }

    @Override
    public List<Job> selectByList() {
        String sql = "select * from job";
        return selectForList(Job.class,sql);
    }

    @Override
    public List<Job> selectJobName(Job job) {
        String sql = "select * from job where username like ?";
        return  selectForList(Job.class,sql,"%"+job.getUsername()+"%");
    }
}
