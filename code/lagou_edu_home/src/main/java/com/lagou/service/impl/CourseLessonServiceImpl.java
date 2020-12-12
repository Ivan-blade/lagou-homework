package com.lagou.service.impl;

import com.lagou.base.StatusCode;
import com.lagou.dao.CourseLessonDao;
import com.lagou.dao.impl.CourseLessonImpl;
import com.lagou.pojo.Course_Lesson;
import com.lagou.service.CourseLessonService;

/**
 * @author apple
 * @date 2020/12/10 下午9:52
 * @description
 */
public class CourseLessonServiceImpl implements CourseLessonService {


    CourseLessonDao courseLessonDao = new CourseLessonImpl();

    @Override
    public String saveCourseLesson(Course_Lesson course_lesson) {
        int i = courseLessonDao.saveCourseLesson(course_lesson);
        if(i > 0){
            //保存成功
            String result = StatusCode.SUCCESS.toString();
            return result;

        }else{
            //保存失败
            String result = StatusCode.FAIL.toString();
            return result;
        }
    }

    @Override
    public String updateCourseLesson(Course_Lesson course_lesson) {
        //调用dao
        int i = courseLessonDao.updateCourseLesson(course_lesson);

        //根据插入是否成功,封装对应信息

        if(i > 0){
            //保存成功
            String result = StatusCode.SUCCESS.toString();
            return result;
        }else{
            //保存失败
            String result = StatusCode.FAIL.toString();
            return result;
        }
    }

    @Override
    public Course_Lesson findCourseLessonById(int id) {
        return courseLessonDao.findCourseLessonById(id);
    }
}
