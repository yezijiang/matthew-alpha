package com.matthew.javabase.webCrawler;

import com.google.common.base.Strings;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-10 17:04
 */
public class ExtractServiceImpl implements ExtractService {
    private List<LinkTypeData> datas = new ArrayList<LinkTypeData>();
    public List<LinkTypeData> extract(Rule rule) throws IOException {
        //对rule进行必要的检验
        validateRule(rule);
        /**
         * 解析rule
         */
        String url = rule.getUrl();
        String[] params = rule.getParams();
        String[] values = rule.getValues();
        String resultTagName = rule.getResultTagName();
        int type = rule.getType();
        int requestType = rule.getRequestMethod();
        Connection conn = Jsoup.connect(url);
        //设置查询参数查询

        if(params != null){
            for(int i=0;i<params.length;i++){
                conn.data(params[i],values[i]);
            }
        }

        Document doc = null;
        switch(requestType){
            case Rule.GET:
                doc = conn.timeout(1000000).get();
                break;
            case Rule.POST:
                break;
        }
        //处理返回数据
        Elements results = new Elements();
        switch (type){
            case Rule.CLASS:
                results = doc.getElementsByClass(resultTagName);
                break;
            case Rule.ID:
                Element result = doc.getElementById(resultTagName);
                results.add(result);
                break;
            case Rule.SELECTION:
                results = doc.select(resultTagName);
                break;
            default:
                //当resultTagName为空时默认去body标签
                if(Strings.isNullOrEmpty(resultTagName)){
                    results = doc.getElementsByTag("body");
                }
        }
        packageData(results);
        return datas;
    }

    public void validateRule(Rule rule) {
        String url = rule.getUrl();
        if(Strings.isNullOrEmpty(url)){
            throw new RuleException("url不能为空");
        }
        if(!url.startsWith("http://")){
            throw new RuleException("url格式不正确");
        }
        if(rule.getParams() != null && rule.getValues() !=null){
            if(rule.getParams().length!=rule.getValues().length){
                throw new RuleException("参数的键值对个数不匹配！");
            }
        }
    }
    public void packageData(Elements results) {
        LinkTypeData data = null;
        for (Element result : results) {
            Elements links = result.getElementsByTag("a");
            for (Element link : links) {
                //必要的筛选
                String linkHref = link.attr("href");
                String linkText = link.text();
                String title = link.attr("title");

                data = new LinkTypeData();
                data.setLinkHref(linkHref);
                data.setContent(linkText);
                data.setSummary(title);

                datas.add(data);
            }
        }
    }
}
