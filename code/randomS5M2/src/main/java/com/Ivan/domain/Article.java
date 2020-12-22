package com.Ivan.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author apple
 * @date 2020/12/19 上午12:13
 * @description
 */
public class Article {

    private Integer id;

    private String title;

    private String content;

    // 表示当前文章代表的评论列表
    private List<Comment> commentList;


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentList=" + commentList +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
