package controller;

import entity.FileSystem;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author apple
 * @date 2021/1/17 上午10:09
 * @description
 */
@Controller
public class FileAction {

    @Autowired
    private Redisson redisson;

    @RequestMapping("upload")
    @ResponseBody
    public void upload1(MultipartHttpServletRequest request) throws Exception{

        // 上传服务器
        MultipartFile file = request.getFile("file");
        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf(".")+1);
        String newFileName = UUID.randomUUID().toString()+"."+suffix;

        // 定义文件识别名
        String fileKey = newFileName;
        // 通过redisson获取锁
        RLock rLock = redisson.getLock(fileKey); // 底层源码就是集成了setnx，过期时间等操作
        // 上锁（过期时间为30秒）
        rLock.lock(30, TimeUnit.SECONDS);

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
        String fileId = client.upload_file1(newFilePath, suffix, list);
        trackerServer.close();

        rLock.unlock();

    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        // 使用单个redis服务器
        config.useSingleServer().setAddress("redis://172.16.161.136:6379").setDatabase(0);
        // 使用集群redis
        // config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://172.16.161.136:6379","redis://172.16.161.135:6379","redis://172.16.161.134:6379");
        return (Redisson)Redisson.create(config);
    }
}
