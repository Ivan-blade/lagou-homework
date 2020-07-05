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
import java.util.List;

/**
 * @author apple
 * @date 2020/7/5 上午9:39
 * @description
 */
@WebServlet(name = "StudentDeleteServlet",urlPatterns = "/studentDelete")
public class StudentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        StudentService studentService = new StudentService();
        int i = studentService.studentDeleteService(Integer.parseInt(id));

        if(i == 0) request.setAttribute("operation","fail to delete data");
        else request.setAttribute("operation","succeed to add data");


        List<Student> students = studentService.studentsSelectAll();
        request.setAttribute("list",students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("task.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
