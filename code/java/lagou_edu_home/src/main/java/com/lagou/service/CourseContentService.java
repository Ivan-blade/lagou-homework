package com.lagou.service;

import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/15 下午3:16
 * @description
 */
public interface CourseContentService {

    String saveCourseLesson(Course_Lesson course_lesson);

    String updateCourseLesson(Course_Lesson course_lesson);

    Course_Lesson findCourseLessonById(int id);

    public List<Course_Section> findSectionAndLessonByCourseId(int courseId);

    public Course findCourseById(int courseId);

    public String saveSection(Course_Section section);

    public String updateSection(Course_Section section);

    public  String  updateSectionStatus(int id,int status);
}
