package com.lagou.demo03.factory;

import com.lagou.demo03.dao.ClassDao;
import com.lagou.demo03.dao.ClassDaoImp;
import com.lagou.demo03.dao.StudentDao;
import com.lagou.demo03.dao.StudentDaoImp;

/**
 * @author apple
 * @date 2020/7/4 下午3:46
 * @description
 */
public class ClassDaoFactory {

    public static ClassDao getClassDao() {
        return new ClassDaoImp();
    }
}
