package com.project.dao.impl;

import com.project.dao.LeaveDao;
import com.project.entity.Leave;

import java.util.List;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 11:03
 **/
public class LeaveDaoImpl extends BaseDao implements LeaveDao {
    @Override
    public List<Leave> selectByPage(int begin, int pageSize) {
        String sql = "select * from `leave` limit ?,?";
        //System.out.println("sql = " + sql);
        return selectForList(Leave.class,sql,begin,pageSize);
    }

    @Override
    public int selectByPageCount() {
        String sql = "select count(1) from `leave`";
        //System.out.println("sql = " + sql);
        Number number = (Number) selectForValue(sql);
        return number.intValue();
    }

    @Override
    public int insertLea(Leave leave) {
        String sql = "insert into `leave` values(?,?,?,?,?,?)";
        return update(sql,0,
                leave.getUsername(),
                leave.getGrade(),
                leave.getDays(),
                leave.getTime(),
                leave.getCause());
    }
}
