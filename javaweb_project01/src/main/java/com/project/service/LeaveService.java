package com.project.service;

import com.project.entity.Leave;
import com.project.entity.PageBean;

/**
 * @Author: ZZH
 * @Description: TODO
 * @DateTime: 2023/6/16 11:07
 **/
public interface LeaveService {
    boolean add(Leave leave);
    PageBean<Leave> selectByPage(int currentPage, int pageSize);
}
