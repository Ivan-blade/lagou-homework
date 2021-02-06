package com.lagou.mapper;

import com.lagou.pojo.Novel;
import com.lagou.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author apple
 * @date 2021/2/6 下午5:37
 * @description
 */
@Mapper
@Component
public interface UserDao {

    @Insert("insert into users(id,username,password,address) values(#{id},#{username},#{password},#{address}))")
    int insertUsers(Users users);


}
