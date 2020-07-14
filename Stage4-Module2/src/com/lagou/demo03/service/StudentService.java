package com.lagou.demo03.service;

import com.lagou.demo03.bean.Student;
import com.lagou.demo03.bean.User;
import com.lagou.demo03.dao.StudentDao;
import com.lagou.demo03.factory.StudentDaoFactory;

import java.util.List;

/**
 * @author apple
 * @date 2020/7/4 下午3:46
 * @description
 */
public class StudentService {

    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = StudentDaoFactory.getStudentDao();
    }

    public int studentInsertService(Student student) {
        return studentDao.studentInsert(student);
    }

    public int studentDeleteService(int id) {
        return studentDao.studentDelete(id);
    }

    public Student studentSelectById(int id) {
        return studentDao.studentSelectById(id);
    }

    public List<Student> studentsSelectAll() {
        return studentDao.studentSelectAll();
    }

    public int studentUpdateService(Student student) {
        return studentDao.studentUpdate(student);
    }

}
