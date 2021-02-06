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
 * @date 2021/2/6 上午10:47
 * @description
 */

@Mapper
@Component
public interface ProductsDao {

    /**
     * 读写分离 插入
     * */
    @Insert("insert into products(pid,pname,price,flag) values(#{pid},#{pname},#{price},#{flag})")
    int insertProduct(@Param("pid") Long pid, @Param("pname") String pname, @Param("price") int price, @Param("flag") String flag);

    /**
     * 读写分离 查询
     * */
    @Select({"select * from products"})
    List<Map> findAll();
}
