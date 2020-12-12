package com.lagou.dao.impl;

import com.lagou.dao.CourseLessonDao;
import com.lagou.pojo.Course_Lesson;
import com.lagou.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author apple
 * @date 2020/12/10 下午9:42
 * @description
 */
public class CourseLessonImpl implements CourseLessonDao {

    @Override
    public int saveCourseLesson(Course_Lesson course_lesson) {

        try {
            //1.创建QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            //2.编写SQL
            String sql = "INSERT INTO course_lesson(\n" +
                    "course_id,\n" +
                    "section_id,\n" +
                    "theme,\n" +
                    "duration,\n" +
                    "is_free,\n" +
                    "order_num\n"+
                    ")VALUES(?,?,?,?,?,?);";

            //3.准备参数
            Object[] param = {course_lesson.getCourse_id(), course_lesson.getSection_id(), course_lesson.getTheme(), course_lesson.getDuration(),
                    course_lesson.getIs_free(), course_lesson.getOrderNum()};

            //4.执行插入操作
            int row = qr.update(sql, param);

            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateCourseLesson(Course_Lesson course_lesson) {

        try {
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            String sql = "UPDATE course_lesson SET \n" +
                    "course_id = ?,\n" +
                    "section_id = ?,\n" +
                    "theme = ?,\n" +
                    "duration = ?,\n" +
                    "is_free = ?,\n" +
                    "order_num = ?\n" +
                    "WHERE id = ?";

            Object[] param = {course_lesson.getCourse_id(), course_lesson.getSection_id(), course_lesson.getTheme(), course_lesson.getDuration(),
                    course_lesson.getIs_free(), course_lesson.getOrderNum(),course_lesson.getId()};

            int row = qr.update(sql, param);
            return row;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Course_Lesson findCourseLessonById(int id) {
        try {
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            String sql = "SELECT \n" +
                    "id,\n" +
                    "course_id,\n" +
                    "section_id,\n" +
                    "theme,\n" +
                    "duration,\n" +
                    "is_free,\n" +
                    "order_num\n" +
                    "FROM course_lesson WHERE id = ?;";

            Course_Lesson course_lesson = qr.query(sql, new BeanHandler<Course_Lesson>(Course_Lesson.class), id);
            return course_lesson;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
