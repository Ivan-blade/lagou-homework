package com.lagou.web.servlet;

import com.lagou.utils.UUIDUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author apple
 * @date 2020/12/6 上午12:55
 * @description
 */
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1.创建磁盘文件项工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            //2.创建文件上传核心类
            ServletFileUpload upload = new ServletFileUpload(factory);
            //2.1 设置上传文件名的编码
            upload.setHeaderEncoding("utf-8");
            //2.2 判断表单是否是文件上传表单
            boolean multipartContent = upload.isMultipartContent(req);
            //2.3 是文件上传表单
            if(multipartContent){

                //3. 解析request ,获取文件项集合
                List<FileItem> list = upload.parseRequest(req);

                if(list != null) {
                    //4.遍历获取表单项
                    for (FileItem item : list) {
                        //5. 判断是不是一个普通表单项
                        boolean formField = item.isFormField();
                        if(formField){
                            //普通表单项, 当 enctype="multipart/form-data"时, request的getParameter()方法 无法获取参数
                            String fieldName = item.getFieldName();
                            String value = item.getString("utf-8");//设置编码
                            System.out.println(fieldName + "=" + value);
                        }else{

                            //文件上传项
                            //文件名
                            String fileName = item.getName();
                            //避免图片名重复 拼接UUID
                            String newFileName = UUIDUtils.getUUID()+"_"+ fileName;

                            //获取上传文件的内容
                            InputStream in = item.getInputStream();

                            String path = this.getServletContext().getRealPath("/");

                            //获取到 webapps路径
                            String webappsPath = path.substring(0, path.indexOf("lagou_edu_home"));
                            OutputStream out = new FileOutputStream(webappsPath+"/upload/"+newFileName);
                            //拷贝文件到服务器
                            IOUtils.copy(in,out);

                            out.close();
                            in.close();
                        }

                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
