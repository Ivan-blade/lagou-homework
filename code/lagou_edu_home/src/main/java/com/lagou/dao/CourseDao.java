package com.lagou.dao;

import com.lagou.pojo.Course;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/5 上午9:43
 * @description
 */
public interface CourseDao {

    public List<Course> findCourseList();

    public List<Course> findByCourseNameAndStatus(String courseName, String status);

    public int saveCourseSalesInfo(Course course);

    public Course findCourseById(int id);

    public int updateCourseSalesInfo(Course course);

    public int updateCourseStatus(Course course);

}
