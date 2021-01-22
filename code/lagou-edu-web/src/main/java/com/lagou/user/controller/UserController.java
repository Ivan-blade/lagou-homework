package com.lagou.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.entity.UploadDTO;
import com.lagou.entity.User;
import com.lagou.entity.UserDTO;
import com.lagou.user.UserService;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: lagou-edu-web
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-08 11:22
 * @Description:
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Reference // 远程消费
    private UserService userService;

    @GetMapping("login")
    public UserDTO login(String phone, String password,String nickname,String headimg) {
        UserDTO dto = new UserDTO();
        User user = null;
        System.out.println("phone = " + phone);
        System.out.println("password = " + password);
        System.out.println("nickname = " + nickname);

        // 检测手机号是否注册
        Integer i = userService.checkPhone(phone);
        if(i == 0){
            // 未注册，自动注册并登录
            userService.register(phone, password,nickname,headimg);
            dto.setMessage("手机号尚未注册，系统已帮您自动注册，请牢记密码！");
            user = userService.login(phone, password);
        }else{
            user = userService.login(phone, password);
            if(user == null){
                dto.setState(300); //300表示失败
                dto.setMessage("帐号密码不匹配，登录失败！");
            }else{
                dto.setState(200); //200表示成功
                dto.setMessage("登录成功！");
            }
        }

        dto.setContent(user);
        return dto;
    }

    @PostMapping("updateUserInfo")
    public UploadDTO updateUserInfo(User user) {

        UploadDTO dto = new UploadDTO();

        System.out.println(user.getId()+" "+user.getName()+" "+user.getPortrait());
        Integer integer = userService.updateUserInfo(user);

        if(integer == 0){
            dto.setSuccess(false);
            dto.setState(300); //300表示失败
            dto.setMessage("修改失败");
        }else{
            dto.setSuccess(true);
            dto.setState(200); //200表示成功
            dto.setMessage("修改成功！");
        }

        return dto;
    }

    @PostMapping("uploadFile")
    public UploadDTO uploadFile(MultipartHttpServletRequest request) throws Exception {
        UploadDTO dto = new UploadDTO();

        // 上传服务器
        MultipartFile file = request.getFile("file");
        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf(".")+1);
        String newFileName = UUID.randomUUID().toString()+"."+suffix;

        File toSaveFile = new File("/Volumes/software/environment/upload/"+newFileName);
        file.transferTo(toSaveFile);
        String newFilePath = toSaveFile.getAbsolutePath();

        // 服务器上传到fastdfs
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

        NameValuePair[] list = new NameValuePair[1];
        list[0] = new NameValuePair("filename",oldFileName);
        // 文件路径
        String fileId = client.upload_file1(newFilePath, suffix, list);
        trackerServer.close();

        if(fileId == null){
            dto.setSuccess(false);
            dto.setState(300); //300表示失败
        }else{
            dto.setSuccess(true);
            dto.setState(200); //200表示成功
            dto.setMessage(fileId);
        }
        return dto;
    }

    @PostMapping("updatePassword")
    public UploadDTO updatePassword(Integer id,String oldpassword,String newpassword) {

        System.out.println(id+" "+oldpassword+" "+newpassword);
        UploadDTO dto = new UploadDTO();

        User u = userService.confirmPassword(id,oldpassword);
        System.out.println(u);
        if(u == null) {
            dto.setSuccess(false);
            dto.setState(300); //300表示失败
            dto.setMessage("原密码错误");
        }

        User user = new User();
        user.setId(id);
        user.setPassword(newpassword);
        Integer integer = userService.updateUserInfo(user);

        if(integer == 0){
            dto.setSuccess(false);
            dto.setState(300); //300表示失败
            dto.setMessage("修改失败");
        }else{
            dto.setSuccess(true);
            dto.setState(200); //200表示成功
            dto.setMessage("修改成功！");
        }

        return dto;
    }



}
