package com.lagou.demo03.factory;

import com.lagou.demo03.dao.StudentDao;
import com.lagou.demo03.dao.StudentDaoImp;

/**
 * @author apple
 * @date 2020/7/4 下午3:46
 * @description
 */
public class StudentDaoFactory {

    public static StudentDao getStudentDao() {
        return new StudentDaoImp();
    }
}
