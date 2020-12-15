package com.lagou.dao;

import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/15 下午3:02
 * @description
 */
public interface CourseContentDao {

    int saveCourseLesson(Course_Lesson course_lesson);

    int updateCourseLesson(Course_Lesson course_lesson);

    Course_Lesson findCourseLessonById(int id);

    public List<Course_Section> findSectionAndLessonByCourseId(int courseId);

    public List<Course_Lesson> findLessonBySectionId(int sectionId);

    public Course findCourseByCourseId(int courseId);
    //保存章节信息
    public int saveSection(Course_Section section);

    public int updateSection(Course_Section section);

    public int updateSectionStatus(int id,int status);
}
