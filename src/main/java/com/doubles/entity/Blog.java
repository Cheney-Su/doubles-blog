package com.doubles.entity;

import com.doubles.utils.HtmlUtils;

/**
 * Created by Administrator on 2016/10/9.
 */
public class Blog {
    private int id;
    private String author;
    private String createTime;
    private int readCount;
    private String title;
    private String blogType;
    private String content;
    private String abstracts;
    private String blogClassName;
    private int blogClassId;
    private String keyWords;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public String getContent() {
        return HtmlUtils.clean(400 > content.length() ? content : content.substring(0, 400));
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getBlogClassName() {
        return blogClassName;
    }

    public void setBlogClassName(String blogClassName) {
        this.blogClassName = blogClassName;
    }

    public int getBlogClassId() {
        return blogClassId;
    }

    public void setBlogClassId(int blogClassId) {
        this.blogClassId = blogClassId;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
