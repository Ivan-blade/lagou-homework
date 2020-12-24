package com.Ivan.service;

import com.Ivan.domain.Employee;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午8:10
 * @description
 */
public interface EmployeeService {

    public List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer emp_id);

    void update(Employee employee);
}
