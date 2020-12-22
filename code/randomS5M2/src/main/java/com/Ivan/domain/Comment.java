package com.Ivan.domain;

import java.io.Serializable;

/**
 * @author apple
 * @date 2020/12/19 上午12:15
 * @description
 */
public class Comment {

    private Integer id;

    private String content;

    private String author;

    private Integer a_id;


    @Override
    public String toString() {
        return "comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", a_id=" + a_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }
}
