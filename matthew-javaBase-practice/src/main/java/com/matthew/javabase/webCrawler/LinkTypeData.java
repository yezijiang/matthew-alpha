package com.matthew.javabase.webCrawler;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-10 17:02
 */
public class LinkTypeData {

    private int id;
    /**
     * 连接的地址
     */
    private String linkHref;
    /**
     * 连接的标题
     */
    private String linkText;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;

    public LinkTypeData() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkHref() {
        return linkHref;
    }

    public void setLinkHref(String linkHref) {
        this.linkHref = linkHref;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
