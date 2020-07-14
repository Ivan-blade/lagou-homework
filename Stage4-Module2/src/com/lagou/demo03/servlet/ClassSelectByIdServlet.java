package com.lagou.demo03.servlet;

import com.lagou.demo03.bean.StuClass;
import com.lagou.demo03.bean.Student;
import com.lagou.demo03.service.ClassService;
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
@WebServlet(name = "ClassSelectByIdServlet",urlPatterns = "/classSelectById")
public class ClassSelectByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        ClassService classService = new ClassService();

        StuClass stuClass = classService.classSelectById(Integer.parseInt(id));

        List<StuClass> classes = new ArrayList<>();
        classes.add(stuClass);

        if(null == stuClass) request.setAttribute("operation","fail to find target");
        else request.setAttribute("operation","succeed to find target");
        request.setAttribute("list",classes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("task02.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
