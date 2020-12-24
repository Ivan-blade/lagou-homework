package com.Ivan.dao;

import com.Ivan.domain.Employee;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午7:38
 * @description
 */
public interface EmployeeDao {

    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer emp_id);

    void update(Employee employee);
}
