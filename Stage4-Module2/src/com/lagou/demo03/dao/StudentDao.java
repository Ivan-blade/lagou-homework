package com.lagou.demo03.dao;

import com.lagou.demo03.bean.Student;

import java.util.List;

/**
 * @author apple
 * @date 2020/7/4 下午3:32
 * @description
 */
public interface StudentDao {

    // 用户增加
    int studentInsert(Student student);

    // 用户删除
    int studentDelete(int id);

    // 根据id查询用户
    Student studentSelectById(int id);

    // 查询所有用户
    List<Student> studentSelectAll();

    // 修改用户信息
    int studentUpdate(Student student);
}
