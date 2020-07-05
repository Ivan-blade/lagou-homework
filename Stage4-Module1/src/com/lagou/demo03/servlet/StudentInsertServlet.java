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
 * @date 2020/7/4 下午7:56
 * @description
 */
@WebServlet(name = "StudentInsertServlet",urlPatterns = "/studentInsert")
public class StudentInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String note = request.getParameter("note");

        StudentService studentService = new StudentService();
        if(null == id || "" == id) {
            System.out.println("servlet gender:" + gender);
            int i = studentService.studentInsertService(new Student(userName, gender, birthday, email, note));

            if(i == 0) request.setAttribute("operation","fail to insert data!");
            else request.setAttribute("operation","succeed to insert data!");

            List<Student> students = studentService.studentsSelectAll();
            request.setAttribute("list",students);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("task.jsp");
            requestDispatcher.forward(request,response);
        } else {
            int i = studentService.studentUpdateService(new Student(Integer.parseInt(id), userName, gender, birthday, email, note));

            if(i == 0) request.setAttribute("operation","fail to update data!");
            else request.setAttribute("operation","succeed to update data!");

            List<Student> students = studentService.studentsSelectAll();
            request.setAttribute("list",students);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("task.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
