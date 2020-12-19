package com.Ivan.mapper;

import com.Ivan.domain.Comment;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/19 下午4:37
 * @description
 */
public interface CommentMapper {

    List<Comment> findByAid(Integer a_id);
}
