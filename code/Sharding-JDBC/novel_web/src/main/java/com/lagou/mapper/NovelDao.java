package com.lagou.mapper;

import com.lagou.pojo.Novel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/2/6 下午5:18
 * @description
 */

@Mapper
@Component
public interface NovelDao {

    @Insert("insert into novel(id,title,author,pic,content) values(#{id},#{title},#{author},#{pic},#{content}))")
    int insertNovel(Novel novel);



    @Select({"<script>" +
            "select " +
            "*"+
            " from novel n" +
            " where n.id in " +
            "<foreach collection='novelIds' item='id' open='(' separator=',' close=')'>" +
            " #{id} " +
            "</foreach>"+
            "</script>"})
    List<Map> findNovelByIds(@Param("novelIds") List<Long> orderIds);
}
