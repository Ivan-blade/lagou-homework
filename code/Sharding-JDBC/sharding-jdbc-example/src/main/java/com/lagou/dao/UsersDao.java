package com.lagou.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/2/6 上午9:53
 * @description
 */

@Mapper
@Component
public interface UsersDao {

    /**
     * 新增用户
     * */
    @Insert("INSERT INTO users(id, username,phone,status) VALUE(#{id},#{username},#{phone},#{status})")
    int insertUser(@Param("id")Long id, @Param("username")String username, @Param("phone")String phone, @Param("status")String status);


    /**
     * 查询用户
     * */
    @Select({"<script>",
            " select",
            " * ",
            " from users u ",
            " where u.id in",
            "<foreach collection='userIds' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
            })
    List<Map> selectUserbyIds(@Param("userIds") List<Long> userIds);
}
