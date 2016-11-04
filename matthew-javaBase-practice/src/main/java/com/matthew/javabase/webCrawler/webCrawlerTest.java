package com.matthew.javabase.webCrawler;

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

    public static void main(String[] args) {
        String html = "<html><head><title>Frist Page</title></head>" +
                "<body><p>a Html wait to be Prased doc</p></body></html>";
        Document doc = Jsoup.parse(html,"www.baidu.com");
       // System.out.println(doc);
        String htmlPart = "<p>this is html Part</p>";
        Document docPart  = Jsoup.parseBodyFragment(htmlPart);
        System.out.println(docPart);

        try {
            Document docUrl = Jsoup.connect("http://www.baidu.com")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .get();
            System.out.println(docUrl);
            File input = new File("/tmp/input.html");
            Document docFile = Jsoup.parse(input, "UTF-8", "http://example.com/");



            Document doc2 = Jsoup.connect("http://www.open-open.com").get();

            Element link = doc2.select("a").first();
            System.out.println(link);
            String relHref = link.attr("href"); // == "/"
            String absHref = link.attr("abs:href"); // "http://www.open-open.com/"
            System.out.println(relHref);
            System.out.println(absHref);



            String unsafe =
                    "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
            String safe = Jsoup.clean(unsafe, Whitelist.basic());
            System.out.println(safe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
