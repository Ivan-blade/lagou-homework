package service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import entity.Users;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

import java.util.List;

/**
 * @BelongsProject: lagou-dubbo
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-27 17:58
 * @Description: 服务实现类
 */
@Service  //暴露服务（向zookeeper注册服务）
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int register(Users users) {
        return userMapper.register(users);
    }

    @Override
    public void deleteUsers(int uid) {
        userMapper.deleteUsers(uid);
    }

    @Override
    public List<Users> findUsers(int uid) {
        return userMapper.findUsers(uid);
    }

    @Override
    public void updateUsers(Users users) {
        userMapper.updateUsers(users);
    }
}
