package com.lagou.base;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

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
        //1.获取参数 要访问的方法名
        // String methodName = req.getParameter("methodName");
        String methodName = null;
        //2.获取POST请求的 Content-Type类型
        String contentType = req.getHeader("Content-Type");
        //3.判断传递的数据是不是JSON格式
        if("application/json;charset=utf-8".equalsIgnoreCase(contentType)){
            //是JOSN格式 调用getPostJSON
            String postJSON = getPostJSON(req);
            //将JSON格式的字符串转化为map
            Map<String,Object> map = JSON.parseObject(postJSON, Map.class);
            //从map集合中获取 methodName
            methodName =(String) map.get("methodName"); //将获取到的数据,保存到request域对象中
            req.setAttribute("map",map);
        }else{
            methodName = req.getParameter("methodName");
        }
        //2.判断 执行对应的方法
        if(methodName != null){
        //通过反射优化代码 提升代码的可维护性
            try {
            //1.获取字节码文件对象
            Class c = this.getClass();
            //2.根据传入的方法名,获取对应的方法对象 findByName
            Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //3.调用method对象的 invoke方法,执行对应的功能
                method.invoke(this,req,resp);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("请求的功能不存在!!");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public String getPostJSON(HttpServletRequest request){
        try {
            //1.从request中获取 字符缓冲输入流对象
            BufferedReader reader = request.getReader();
            //2.创建 StringBuffer,用来保存读取出的数据
            StringBuffer sb = new StringBuffer();
            //3.循环读取
            String line = null;
            while((line = reader.readLine()) != null){
                //追加到 StringBuffer中
                sb.append(line);
            }
        //4.将读取到的内容转换为字符串,并返回
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
