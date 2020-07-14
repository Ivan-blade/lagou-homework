package com.lagou.demo03.filter;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author apple
 * @date 2020/7/12 上午10:27
 * @description
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        Cookie[] cookies = httpServletRequest.getCookies();
        String username = null;
        for(Cookie temp : cookies) {
            if("user".equals(temp.getName()) && temp.getValue() != null) {
                username = temp.getValue();
            }
        }

        String serveltPath = httpServletRequest.getServletPath();
        if( null == username && !serveltPath.contains("login")) {
            httpServletRequest.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
        } else {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user",username);
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
