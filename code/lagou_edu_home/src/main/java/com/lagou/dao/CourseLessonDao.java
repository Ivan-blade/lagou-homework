package com.lagou.dao;

import com.lagou.pojo.Course_Lesson;

/**
 * @author apple
 * @date 2020/12/10 下午9:42
 * @description
 */
public interface CourseLessonDao {

    int saveCourseLesson(Course_Lesson course_lesson);

    int updateCourseLesson(Course_Lesson course_lesson);

    Course_Lesson findCourseLessonById(int id);
}
