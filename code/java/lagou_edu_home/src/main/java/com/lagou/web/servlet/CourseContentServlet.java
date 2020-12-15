package com.lagou.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;
import com.lagou.service.CourseContentService;
import com.lagou.service.CourseService;
import com.lagou.service.impl.CourseContentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2020/12/12 下午2:38
 * @description
 */
@WebServlet(name = "courseContentServlet",value = "/courseContent")
public class CourseContentServlet extends BaseServlet {

    public void findCourseLessonById(HttpServletRequest request , HttpServletResponse response){

        try {
            //1.接收参数
            String id = request.getParameter("id");
            //2.业务处理
            CourseContentService cs = new CourseContentServiceImpl();
            Course_Lesson course_lesson = cs.findCourseLessonById(Integer.parseInt(id));

            //3.返回结果 响应JSON格式数据
            //使用 SimplePropertyPreFilter,指定要转换为JSON的字段
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course_Lesson.class,"id","course_id","section_id","theme","duration",
                    "is_free","order_num");

            String result  = JSON.toJSONString(course_lesson, filter);
            response.getWriter().println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void saveOrUpdateCourseLesson(HttpServletRequest request , HttpServletResponse response){
        try {

            //1.接收参数
            String id = request.getParameter("id");
            String course_id = request.getParameter("course_id");
            String section_id = request.getParameter("section_id");
            String theme = request.getParameter("theme");
            String duration = request.getParameter("duration");
            String is_free = request.getParameter("is_free");
            String order_num = request.getParameter("order_num");

            //2.创建Course对象
            Course_Lesson course_lesson = new Course_Lesson();

            course_lesson.setCourse_id(Integer.parseInt(course_id));
            course_lesson.setSection_id(Integer.parseInt(section_id));
            course_lesson.setTheme(theme);
            course_lesson.setDuration(Integer.parseInt(duration));
            course_lesson.setIs_free(Integer.parseInt(is_free));
            course_lesson.setOrderNum(Integer.parseInt(order_num));

            CourseContentService cs = new CourseContentServiceImpl();

            if(id != null){
                course_lesson.setId(Integer.parseInt(id));
                String result = cs.updateCourseLesson(course_lesson);
                //响应结果
                response.getWriter().print(result);

            }else{
                String result = cs.saveCourseLesson(course_lesson);
                //响应结果
                response.getWriter().print(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    public void saveOrUpdateCourseLesson(HttpServletRequest request , HttpServletResponse response){
        try {

            //1.获取参数
            Map<String, Object> map = (Map) request.getAttribute("map");
            //2.创建 Course_Section
            Course_Lesson lesson = new Course_Lesson();
            //3.使用BeanUtils,将map中的数据封装到section对象里
            BeanUtils.copyProperties(lesson, map.get("lesson"));
            // BeanUtils.copyProperties(section, map);
            //4.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            if (lesson.getId() != 0) { //修改操作
                String result = contentService.updateCourseLesson(lesson);
                //5.返回结果数据
                response.getWriter().println(result);
            } else {
                //添加操作
                String result = contentService.saveCourseLesson(lesson);
                //5.返回结果数据
                response.getWriter().println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findSectionAndLessonByCourseId(HttpServletRequest request , HttpServletResponse response){
        try {
            //1.获取参数
            String course_id = request.getParameter("course_id");
            //2.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            List<Course_Section> sectionList = contentService.findSectionAndLessonByCourseId(Integer.parseInt(course_id));
            //3.返回结果
            String result = JSON.toJSONString(sectionList); response.getWriter().println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findCourseById(HttpServletRequest request , HttpServletResponse response){
        try {
            //1.获取参数
            String courseId = request.getParameter("course_id");
            //2.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            Course course = contentService.findCourseById(Integer.parseInt(courseId));
            //3.返回数据,将对象转换为JSON,只转换需要的字段
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course.class,"id","course_name");
            String result = JSON.toJSONString(course,filter);
            response.getWriter().println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOrUpdateSection(HttpServletRequest request , HttpServletResponse response) {
        try {
            //1.获取参数
            Map<String, Object> map = (Map) request.getAttribute("map");
            //2.创建 Course_Section
            Course_Section section = new Course_Section();
            //3.使用BeanUtils,将map中的数据封装到section对象里
            BeanUtils.copyProperties(section, map.get("section"));
            // BeanUtils.copyProperties(section, map);
            //4.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            if (section.getId() != 0) { //修改操作
                String result = contentService.updateSection(section);
                //5.返回结果数据
                response.getWriter().println(result);
            } else {
                //添加操作
                String result = contentService.saveSection(section);
                //5.返回结果数据
                response.getWriter().println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSectionStatus(HttpServletRequest request , HttpServletResponse response) {
        try {
            //1.获取参数
            int id = Integer.parseInt(request.getParameter("id"));
            int status = Integer.parseInt(request.getParameter("status"));
            //4.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            String result = contentService.updateSectionStatus(id, status);
            //5.返回结果数据findSectionById
            response.getWriter().println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

