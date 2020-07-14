package com.lagou.demo03.service;

import com.lagou.demo03.bean.StuClass;
import com.lagou.demo03.bean.Student;
import com.lagou.demo03.dao.ClassDao;
import com.lagou.demo03.dao.StudentDao;
import com.lagou.demo03.factory.ClassDaoFactory;
import com.lagou.demo03.factory.StudentDaoFactory;

import java.util.List;

/**
 * @author apple
 * @date 2020/7/4 下午3:46
 * @description
 */
public class ClassService {

    private ClassDao classDao;

    public ClassService() {
        this.classDao = ClassDaoFactory.getClassDao();
    }

    public int classInsertService(StuClass stuClass) {
        return classDao.classInsert(stuClass);
    }

    public int classDeleteService(int id) {
        return classDao.classDelete(id);
    }

    public StuClass classSelectById(int id) {
        return classDao.classSelectById(id);
    }

    public List<StuClass> classSelectAll() {
        return classDao.classSelectAll();
    }

    public int classUpdateService(StuClass stuClass) {
        return classDao.classUpdate(stuClass);
    }

}
