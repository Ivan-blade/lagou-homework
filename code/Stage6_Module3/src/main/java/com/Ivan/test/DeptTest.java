package com.Ivan.test;

import com.Ivan.domain.Department;
import com.Ivan.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午4:29
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeptTest {


    @Autowired
    private DeptService deptService;

    @Test
    public void randomTest1() {


        List<Department> list = deptService.findAll();
        System.out.println(list);
    }
}
