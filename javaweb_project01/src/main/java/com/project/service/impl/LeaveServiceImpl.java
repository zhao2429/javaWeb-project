package com.project.service.impl;

import com.project.dao.LeaveDao;
import com.project.dao.impl.LeaveDaoImpl;
import com.project.entity.Leave;
import com.project.entity.PageBean;
import com.project.service.LeaveService;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 11:08
 **/
public class LeaveServiceImpl implements LeaveService {
    private LeaveDao leaveDao = new LeaveDaoImpl();
    @Override
    public boolean add(Leave leave) {
        return leaveDao.insertLea(leave) > 0;
    }

    @Override
    public PageBean<Leave> selectByPage(int currentPage, int pageSize) {
        //求出分页的开始索引
        int begin = (currentPage-1)*pageSize;
        //查询分页数据
        List<Leave> leaveList = leaveDao.selectByPage(begin, pageSize);
        //分页的count
        int count = leaveDao.selectByPageCount();
        PageBean<Leave> leavePageBean = new PageBean<>(leaveList,count);
        return leavePageBean;
    }
}
