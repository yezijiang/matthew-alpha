package com.matthew.javabase.webCrawler.gecco;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-23 11:09
 */
public class Category implements HtmlBean {

    private static final long serialVersionUID = 1453306025661311129L;
    @Text
    @HtmlField(cssPath="dt a")
    private String parentName;
    @Text
    @HtmlField(cssPath="dd a")
    private List<HrefBean> categorys;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<HrefBean> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<HrefBean> categorys) {
        this.categorys = categorys;
    }
}
