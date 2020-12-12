package com.lagou.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course_Lesson;
import com.lagou.service.CourseLessonService;
import com.lagou.service.impl.CourseLessonServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            System.out.println("正在查询id="+id+"的数据");
            //2.业务处理
            CourseLessonService cs = new CourseLessonServiceImpl();
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

    public void saveOrUpdateCourseLesson(HttpServletRequest request , HttpServletResponse response){

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

            CourseLessonService cs = new CourseLessonServiceImpl();

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

}
