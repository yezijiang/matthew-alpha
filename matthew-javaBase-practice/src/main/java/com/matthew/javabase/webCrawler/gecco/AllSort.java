package com.matthew.javabase.webCrawler.gecco;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-23 10:48
 */
@Gecco(matchUrl = "http://www.jd.com/allsort.aspx",pipelines = {"consolePipeline","allSortPipeline"})
public class AllSort implements HtmlBean{
    private static final long serialVersionUID = -7860641325400749366L;
    @Request
    private HttpRequest request;
    //手机  如何获取：F12选中，右键Copy-Copy Selector 即可以获取到
    @HtmlField(cssPath = "category-items > div:nth-child(1) > div:nth-child(2) > div.mc > div.items> dl")
    private List<Category> mobile;

    //家用电器
    @HtmlField(cssPath = "category-items > div:nth-child(1) > div:nth-child(3) > div.mc > div.items> dl")
    private List<Category> domestic;

    public List<Category> getDomestic() {
        return domestic;
    }

    public void setDomestic(List<Category> domestic) {
        this.domestic = domestic;
    }

    public List<Category> getMobile() {
        return mobile;
    }

    public void setMobile(List<Category> mobile) {
        this.mobile = mobile;
    }




}
