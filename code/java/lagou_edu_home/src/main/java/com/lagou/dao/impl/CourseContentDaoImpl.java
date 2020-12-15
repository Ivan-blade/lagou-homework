package com.lagou.dao.impl;

import com.lagou.dao.CourseContentDao;
import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;
import com.lagou.utils.DateUtils;
import com.lagou.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author apple
 * @date 2020/12/15 下午3:06
 * @description
 */
public class CourseContentDaoImpl implements CourseContentDao {

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
                    "order_num\n" +
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
                    course_lesson.getIs_free(), course_lesson.getOrderNum(), course_lesson.getId()};

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

    @Override
    public List<Course_Section> findSectionAndLessonByCourseId(int courseId) {
        try {
            //1.创建QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            //2.编写SQL
            String sql = "SELECT \n" +
                    "id,\n" +
                    "course_id,\n" +
                    "section_name,\n" +
                    "description,\n" +
                    "order_num,\n" +
                    "STATUS\n" +
                    "FROM course_section WHERE course_id = ?";
            //3.执行查询
            List<Course_Section> sectionList = qr.query(sql, new
                    BeanListHandler<Course_Section>(Course_Section.class), courseId);
            //4.根据章节ID查询课时信息
            for (Course_Section section : sectionList) {
                //调用方法 获取章节对应的课时
                List<Course_Lesson> lessonList =
                        findLessonBySectionId(section.getId());
                //将课时数据封装到 章节对象中
                section.setLessonList(lessonList);
            }
            return sectionList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据章节ID查询课时信息
    @Override
    public List<Course_Lesson> findLessonBySectionId(int sectionId) {
        try {
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            String sql = "SELECT \n" +
                    "id,\n" +
                    "course_id,\n" +
                    "section_id,\n" +
                    "theme,\n" +
                    "duration,\n" +
                    "is_free,\n" +
                    "order_num,\n" +
                    "STATUS\n" +
                    "FROM course_lesson WHERE section_id = ?";
            List<Course_Lesson> lessonList = qr.query(sql, new
                    BeanListHandler<Course_Lesson>(Course_Lesson.class), sectionId);
            return lessonList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Course findCourseByCourseId(int courseId) {
        try {
            //1.创建QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            //2.编写SQL
            String sql = "SELECT id,course_name FROM course WHERE id = ?";
            //3.执行查询
            Course course = qr.query(sql, new BeanHandler<Course>(Course.class), courseId);
            //4.返回结果
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int saveSection(Course_Section section) {
        try {
            //1.创建QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            //2.编写SQL
            String sql = "INSERT INTO course_section(course_id,section_name,description,order_num,STATUS,create_time,update_time)\n" +
                    "VALUES(?,?,?,?,?,?,?);";
            //3.准备参数
            Object[] param =
                    {section.getCourse_id(), section.getSection_name(), section.getDescription(),
                            section.getOrder_num(), section.getStatus(), section.getCreate_time(), section.getUpdate_time()};
            //4.执行插入
            // int i = qr.update(sql, section.getCourse_id(), param);
            int i = qr.update(sql, param);
            //5.返回结果
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateSection(Course_Section section) {
        try {
        //1.创建QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2.编写SQL
            String sql = "UPDATE course_section SET\n" +
                    "section_name = ?,\n" +
                    "description = ?,\n" +
                    "order_num = ?,\n" +
                    "update_time = ?  WHERE id = ?;";
        //3.准备参数
            Object[] param =
                    {section.getSection_name(),section.getDescription(),section.getOrder_num(),
                            section.getUpdate_time(),section.getId()};
            //4.执行修改操作
            int row = qr.update(sql,param);
            // int row = qr.update(sql, section.getCourse_id(),param);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateSectionStatus(int id,int status) {
        try {
            //1.创建QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            //2.编写SQL
            String sql = "UPDATE course_section SET STATUS = ?,update_time = ? WHERE id = ?;";
            //3.准备参数
            Object[] param = {status, DateUtils.getDateFormart(), id};
            //4.执行修改操作
            int row = qr.update(sql, param);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
