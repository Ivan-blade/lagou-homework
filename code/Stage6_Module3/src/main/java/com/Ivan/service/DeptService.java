package com.Ivan.service;

import com.Ivan.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午4:35
 * @description
 */
public interface DeptService {

    public List<Department> findAll();

}
