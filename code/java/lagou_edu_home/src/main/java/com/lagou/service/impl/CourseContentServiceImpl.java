package com.lagou.service.impl;

import com.lagou.base.StatusCode;
import com.lagou.dao.CourseContentDao;
import com.lagou.dao.impl.CourseContentDaoImpl;
import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;
import com.lagou.service.CourseContentService;
import com.lagou.utils.DateUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2020/12/15 下午3:17
 * @description
 */
public class CourseContentServiceImpl implements CourseContentService {



    CourseContentDao contentDao = new CourseContentDaoImpl();

    @Override
    public String saveCourseLesson(Course_Lesson course_lesson) {
        int i = contentDao.saveCourseLesson(course_lesson);
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
        int i = contentDao.updateCourseLesson(course_lesson);

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
        return contentDao.findCourseLessonById(id);
    }

    @Override
    public List<Course_Section> findSectionAndLessonByCourseId(int courseId) {
        List<Course_Section> sections =
                contentDao.findSectionAndLessonByCourseId(courseId);
        return sections;
    }

    @Override
    public Course findCourseById(int courseId) {
        Course course = contentDao.findCourseByCourseId(courseId);
        return course;
    }

    @Override
    public String saveSection(Course_Section section) {
        //1.补全章节信息
        section.setStatus(2); //状态，0:隐藏;1:待更新;2:已发布
        String date = DateUtils.getDateFormart();
        section.setCreate_time(date);
        section.setUpdate_time(date);
        //2.调用Dao进行插入
        int i = contentDao.saveSection(section);
        //3.根据插入是否成功,封装对应信息
        if(i > 0){
            //保存成功
            String result = StatusCode.SUCCESS.toString();
            return result;
        }else{ //保存失败
            String result = StatusCode.FAIL.toString();
            return result;
        }
    }

    public void saveOrUpdateSection(HttpServletRequest request, HttpServletResponse response){
        try {
            //1.获取参数 从域对象中获取
            Map<String,Object> map = (Map)request.getAttribute("map");
            //2.创建Course_Section
            Course_Section section = new Course_Section();
            //3.使用BeanUtils工具类,将map中的数据封装到 section
            BeanUtils.populate(section,map);
            //4.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            String result = contentService.saveSection(section);
            //5.响应结果
            response.getWriter().print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public  String updateSection(Course_Section section) {
        //1.补全章节信息
        String date = DateUtils.getDateFormart();
        section.setUpdate_time(date);
        //2.调用Dao进行插入
        int i = contentDao.updateSection(section);
        //3.根据修改是否成功,封装对应信息
        if(i > 0){
            //保存成功
            String result = StatusCode.SUCCESS.toString();
            return result;
        }else {
            //保存失败
            String result = StatusCode.FAIL.toString();
            return result;
        }
    }

    @Override
    public String updateSectionStatus(int id, int status) { //调用Dao 修改状态
        int i = contentDao.updateSectionStatus(id,status);
        //3.根据修改是否成功,封装对应信息
        if(i > 0){
            String result = StatusCode.SUCCESS.toString();
            return result;
        }else{
            String result = StatusCode.FAIL.toString();
            return result;
        }
    }
}
