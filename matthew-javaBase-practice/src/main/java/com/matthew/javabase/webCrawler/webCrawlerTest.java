package com.matthew.javabase.webCrawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-12 15:32
 */
public class webCrawlerTest {
    public ExtractService extractService = new ExtractServiceImpl();

    public void getDatasByCssQuery() throws IOException {
        Rule rule = new Rule("http://www.ehaoyao.com/search/感冒",
                new String[]{},
                new String[]{},
                "ul#result > li>p.title > a[target=_blank]",
                Rule.SELECTION,
                Rule.GET);

        List<LinkTypeData> extracts = extractService.extract(rule);
        printf(extracts);
    }

    public void printf(List<LinkTypeData> datas){
        for(LinkTypeData data:datas){
            System.out.println(data.getSummary());
            System.out.println(data.getLinkHref());
            System.out.println("**************************");
        }
    }

    public static void main(String[] args) throws IOException {
        //webCrawlerTest test = new webCrawlerTest();
        //test.getDatasByCssQuery();
        String url = " http://www.ehaoyao.com";
        Document doc = null;
        Connection conn = Jsoup.connect(url);
        conn.header(
                "User-Agent",
                "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        try {
            doc = conn.timeout(10000).get();
            System.out.println(doc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
