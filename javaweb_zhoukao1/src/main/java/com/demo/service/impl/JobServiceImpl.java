package com.demo.service.impl;

import com.demo.dao.JobDao;
import com.demo.dao.impl.JobDaoImpl;
import com.demo.entity.Job;
import com.demo.service.JobService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/5/27 15:12
 **/
public class JobServiceImpl implements JobService {
    private JobDao jobDao = new JobDaoImpl();
    @Override
    public boolean add(Job job) {
        return jobDao.insertJob(job) > 0;
    }

    @Override
    public boolean remove(Job job) {
        return jobDao.deleteJob(job) > 0;
    }

    @Override
    public boolean modify(Job job) {
        return jobDao.updateJob(job) > 0;
    }

    @Override
    public Job findById(Job job) {
        return jobDao.selectById(job);
    }

    @Override
    public Job login(Job job) {
        return jobDao.selectByUserAndPassWord(job);
    }

    @Override
    public List<Job> findByAll() {
        return jobDao.selectByList();
    }

    @Override
    public List<Job> find(Job job) {
        return jobDao.selectJobName(job);
    }
}
