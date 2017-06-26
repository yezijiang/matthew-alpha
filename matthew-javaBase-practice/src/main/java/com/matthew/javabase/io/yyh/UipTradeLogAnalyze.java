package com.matthew.javabase.io.yyh;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-05-16 17:28
 */
public class UipTradeLogAnalyze {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\maxing\\Documents\\Tencent Files\\914384315\\FileRecv\\sss2.htm");

        try {
            Document doc  = Jsoup.parse(file,"UTF-8");

            Elements elements = doc.getElementsByTag("tr");
            for(Element element:elements){
                Elements elements2 = element.getElementsByIndexEquals(8);
                for(Element element2:elements2){
                    String requestStr = ZipUtils.gunzip(element2.text().replaceAll(" ",""));
                    System.out.println(StringUtils.substringBetween(requestStr,"<orderId>","</orderId>"));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        String str = "H4sIAAAAAAAAAGWTyW7bMBCG73mKlLka0ZBavEAQshRFfUhjJLkVPVDiBCGihaGoAEbgdy8XS7YQnTjf/EP+w6HyQaon/BiwN8XF5WVuw9/IhVv7SBRpCTTjtAKW8SRdJqsVspK9lsmalSksMY+cKui5UvedwGK3e86jMRi3UreDeduK4sfNVZJmrmwkQdGj/pQV+ppHLVA/B5BH55mg7RRqbmTXFp1T7vi+wdbk0YkHXclK292LbLBgQJeQ0owCA4B1DHl0lp1MjsD7m2c19uqYm5Yh86q7ZqssPy4C/eS1FC97hQUAzaNTGNIGdSNbXp8UMzKe2XD9Tv2RYXXO2cTZjMcTj/1Uo7OxuibvOrEvvoji+9uq6obW/ETDZd2TzXdINn89/IVINnTN4DpLF8RYi2RDGDn8Oyxc+sEOxwIgPnrCfqiNi+1nkdG87XnlJmOnKnn9p3PV00gAWBInKUAW6u81CmkebAOnPece5+aOp9Og9FbJ0Ss5LL6+GwwSuLbufAf+GW2FK4PRFkAMy1Vse/QX6C/tYnwX/o/5Dzo+B5U+AwAA";
//        try {
//            System.out.println(ZipUtils.gunzip(str));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }



}
