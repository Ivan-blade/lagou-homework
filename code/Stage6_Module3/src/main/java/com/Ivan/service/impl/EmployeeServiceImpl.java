package com.Ivan.service.impl;

import com.Ivan.dao.EmployeeDao;
import com.Ivan.domain.Employee;
import com.Ivan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午8:12
 * @description
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /*
        查询全部员工
     */
    public List<Employee> findAll() {
        List<Employee> all = employeeDao.findAll();
        return all;
    }


    /*
        员工添加
     */
    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    /* 员工查询 */
    @Override
    public Employee findById(Integer emp_id) {
        return employeeDao.findById(emp_id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }


}
