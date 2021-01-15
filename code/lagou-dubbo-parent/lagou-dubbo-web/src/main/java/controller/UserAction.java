package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 18:16
 * @Description: 控制层
 */
@Controller
public class UserAction {

    @Reference
    private UserService userService;

    @RequestMapping("/register")
    public String register(Users user) {
        try {
            String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            user.setCreatetime(nowTime);
            userService.register(user);
            return "注册成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

    @RequestMapping(value = "/select/{uid}",method = RequestMethod.GET)
    public List<Users> findUsers(@PathVariable("uid") int uid) {
        List<Users> users = userService.findUsers(uid);
        return users;
    }

    @RequestMapping("/delete")
    public void deleteUsers(int uid){
        userService.deleteUsers(uid);
    }

    @RequestMapping("/update")
    public void updateUsers(Users users) {
        userService.updateUsers(users);
    }

}
