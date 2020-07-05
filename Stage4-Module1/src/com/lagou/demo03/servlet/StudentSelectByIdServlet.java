package com.lagou.demo03.servlet;

import com.lagou.demo03.bean.Student;
import com.lagou.demo03.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author apple
 * @date 2020/7/5 上午9:45
 * @description
 */
@WebServlet(name = "StudentSelectByIdServlet",urlPatterns = "/studentSelectById")
public class StudentSelectByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        StudentService studentService = new StudentService();

        Student student = studentService.studentSelectById(Integer.parseInt(id));

        List<Student> students = new ArrayList<>();
        students.add(student);

        if(null == student) request.setAttribute("operation","fail to find target");
        else request.setAttribute("operation","succeed to find target");
        request.setAttribute("list",students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("task.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
