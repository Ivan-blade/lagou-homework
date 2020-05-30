package com.Ivan.model;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/30 9:37
 * @description 试题类包含编号和内容
 */
public class Title implements Serializable {

    private static final long serialVersionUID = -8588490692533739681L;
    private String id;
    private String content;

    public Title(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
