package com.buy.entity;

import java.io.Serializable;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/18 11:14
 * @Modified By:
 */
public class easybuy_news implements Serializable {
    private int id;
    private String title;
    private String content;
    private String createTime;

    public easybuy_news(int id, String title, String content, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public easybuy_news() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}



