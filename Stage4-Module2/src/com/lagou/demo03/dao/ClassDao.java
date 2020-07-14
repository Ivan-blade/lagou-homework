package com.lagou.demo03.dao;

import com.lagou.demo03.bean.StuClass;
import com.lagou.demo03.bean.Student;

import java.util.List;

/**
 * @author apple
 * @date 2020/7/4 下午3:32
 * @description
 */
public interface ClassDao {

    // 用户增加
    int classInsert(StuClass stuClass);

    // 用户删除
    int classDelete(int id);

    // 根据id查询用户
    StuClass classSelectById(int id);

    // 查询所有用户
    List<StuClass> classSelectAll();

    // 修改用户信息
    int classUpdate(StuClass stuClass);
}
