package com.Ivan.service.impl;

import com.Ivan.dao.DeptDao;
import com.Ivan.domain.Department;
import com.Ivan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午4:38
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    public List<Department> findAll() {
        return deptDao.findAll();
    }
}
