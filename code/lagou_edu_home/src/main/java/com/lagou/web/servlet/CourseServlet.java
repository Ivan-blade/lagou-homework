package com.lagou.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course;
import com.lagou.service.CourseService;
import com.lagou.service.impl.CourseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author apple
 * @date 2020/12/5 上午9:44
 * @description
 */
@WebServlet(name = "courseServlet",value = "/course")
public class CourseServlet extends BaseServlet {

    //查询课程信息列表
    public void findCourseList(HttpServletRequest request, HttpServletResponse response){

        try {
            //1.接收参数

            //2.业务处理
            CourseService cs = new CourseServiceImpl();
            List<Course> courseList = cs.findCourseList();

            //3.响应结果
            //SimplePropertyPreFilter 指定要转换的JSON字段
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course.class,
                    "id","course_name","price","sort_num","status");

            String result = JSON.toJSONString(courseList,filter);
            response.getWriter().print(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByCourseNameAndStatus(HttpServletRequest request , HttpServletResponse response){

        try {
            //1.接收参数
            String courseName = request.getParameter("course_name");
            String status = request.getParameter("status");

            //2.业务处理
            CourseService cs = new CourseServiceImpl();
            List<Course> courseList = cs.findByCourseNameAndStatus(courseName, status);

            //3.返回结果 响应JSON格式数据
            //使用 SimplePropertyPreFilter,指定要转换为JSON的字段
            SimplePropertyPreFilter filter =
                    new SimplePropertyPreFilter(Course.class,"id","course_name","price","sort_num","status");

            String result = JSON.toJSONString(courseList, filter);
            response.getWriter().println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findCourseById(HttpServletRequest request , HttpServletResponse response){

        try {
            //1.接收参数
            String id = request.getParameter("id");

            //2.业务处理
            CourseService cs = new CourseServiceImpl();
            Course course = cs.findCourseById(Integer.parseInt(id));

            //3.返回结果 响应JSON格式数据
            //使用 SimplePropertyPreFilter,指定要转换为JSON的字段
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course.class,"id","course_name","brief","teacher_name",
                    "teacher_info","preview_first_field","preview_second_field","discounts","price","price_tag","share_image_title","share_title","share_description","course_description");

            String result  = JSON.toJSONString(course, filter);
            response.getWriter().println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
