package com.lagou.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author apple
 * @date 2021/2/6 上午10:19
 * @description
 */

@Mapper
@Component
public interface DistrictDao {

    /**
     * 插入数据
     * @param district_name
     * @param level
     */
    @Insert("INSERT INTO district(district_name,level) VALUES(#{district_name},#{level})")
    public void insertDist(@Param("district_name") String district_name,@Param("level") int level);

    /**
     * 删除数据 */
    @Delete("delete from district where id = #{id}")
    int deleteDict(@Param("id") Long id);
}
