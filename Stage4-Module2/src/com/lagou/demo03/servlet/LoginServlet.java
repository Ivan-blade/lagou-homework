package com.lagou.demo03.servlet;

import com.lagou.demo03.bean.Student;
import com.lagou.demo03.bean.User;
import com.lagou.demo03.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求中的用户名和密码信
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        // 2.创建UserService类型的对象去实现数据的校验功能
        UserService userService = new UserService();
        User user = userService.userLoginService(new User(userName, password));
        if (null == user) {
            request.setAttribute("error", "登录失败，用户名或密码错误！");
            // 实现服务器跳转  共享request和response对象
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            // 将登陆成功的用户信息放入cookie
            Cookie cookie = new Cookie("user",user.getUserName());
            cookie.setMaxAge(7*24*60*60);
            // cookie.setMaxAge(10);
            response.addCookie(cookie);

            // 实现客户端跳转
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("task.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
