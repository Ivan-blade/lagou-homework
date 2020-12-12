package com.lagou.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author apple
 * @date 2020/12/5 上午1:12
 * @description
 */
public class BaseServlet extends HttpServlet {

    /**
     *  doGet()方法作为调度器 控制器,根据请求的功能不同,调用对应的方法
     *
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1.获取参数
            //获取要调用的方法名
            String methodName = req.getParameter("methodName");

            //2.业务处理
            if(methodName != null){
                //通过反射优化代码,提升代码的可维护性
                //1.获取字节码对象  this = TestServlet对象
                Class c = this.getClass();

                //2.根据传入的方法名, 获取对应方法对象,执行方法即可
                Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

                //3.调用Method对象的 invoke()方法,执行对应的功能
                method.invoke(this,req,resp);
            }
        } catch (Exception e) {
            System.out.println("请求的功能不存在! !");
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}
