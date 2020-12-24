package com.Ivan.dao;

import com.Ivan.domain.Department;
import com.Ivan.domain.Employee;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午4:31
 * @description
 */
public interface DeptDao {

    List<Department> findAll();


}
