package com.lagou.service;

import com.lagou.pojo.Course_Lesson;

/**
 * @author apple
 * @date 2020/12/10 下午9:52
 * @description
 */
public interface CourseLessonService {

    String saveCourseLesson(Course_Lesson course_lesson);

    String updateCourseLesson(Course_Lesson course_lesson);

    Course_Lesson findCourseLessonById(int id);
}
