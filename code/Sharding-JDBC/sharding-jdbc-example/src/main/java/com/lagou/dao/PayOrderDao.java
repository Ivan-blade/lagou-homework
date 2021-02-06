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
 * @date 2021/2/5 下午7:53
 * @description
 */

@Mapper
@Component
public interface PayOrderDao {

    @Insert("insert into pay_order(user_id,product_name,COUNT) values(#{user_id},#{product_name},#{count})")
    int insertPayOrder(@Param("user_id") int user_id, @Param("product_name") String product_name, @Param("count") int count);


    @Select({"<script>" +
            "select " +
            "*"+
            " from pay_order p" +
            " where p.order_id in " +
            "<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>" +
                " #{id} " +
            "</foreach>"+
            "</script>"})
    List<Map> findOrderByIds(@Param("orderIds") List<Long> orderIds);
}
