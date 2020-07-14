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
import java.util.List;

/**
 * @author apple
 * @date 2020/7/4 下午7:56
 * @description
 */
@WebServlet(name = "ClassInsertServlet",urlPatterns = "/classInsert")
public class ClassInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String masterName = request.getParameter("masterName");
        String location = request.getParameter("location");
        String note = request.getParameter("note");

        ClassService classService = new ClassService();
        if(null == id || "".equals(id)) {
            int i = classService.classInsertService(new StuClass(name, level, masterName, location, note));

            if(i == 0) request.setAttribute("operation","fail to insert data!");
            else request.setAttribute("operation","succeed to insert data!");

            List<StuClass> classes = classService.classSelectAll();
            request.setAttribute("list",classes);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("task02.jsp");
            requestDispatcher.forward(request,response);
        } else {
            int i = classService.classUpdateService(new StuClass(Integer.parseInt(id), name, level, masterName, location, note));

            if(i == 0) request.setAttribute("operation","fail to update data!");
            else request.setAttribute("operation","succeed to update data!");

            List<StuClass> classes = classService.classSelectAll();
            request.setAttribute("list",classes);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("task02.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
