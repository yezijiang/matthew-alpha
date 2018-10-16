package com.matthew.javabase.io.yyh;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-05-16 17:28
 */
public class UipTradeLogAnalyze {
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\maxing\\Documents\\Tencent Files\\914384315\\FileRecv\\sss2.htm");
//
//        try {
//            Document doc  = Jsoup.parse(file,"UTF-8");
//
//            Elements elements = doc.getElementsByTag("tr");
//            for(Element element:elements){
//                Elements elements2 = element.getElementsByIndexEquals(8);
//                for(Element element2:elements2){
//                    String requestStr = ZipUtils.gunzip(element2.text().replaceAll(" ",""));
//                    System.out.println(StringUtils.substringBetween(requestStr,"<orderId>","</orderId>"));
//                }
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<String> picList = new ArrayList<>();
        int i =1;
        while(i<37){
            String picHead = "http://img1001.aoyuanba.com/mh160tuku/q/%C7%E0%B4%BA%CB%AE%C7%F2%C9%E7_14981/%B5%DA2%BB%B0_223723/000"+i+".jpg";
                              http://img1001.aoyuanba.com/mh160tuku/q/%C7%E0%B4%BA%CB%AE%C7%F2%C9%E7_14981/%B5%DA3%BB%B0_223724/0020.jpg
            if(i>9){
                picHead = "http://img1001.aoyuanba.com/mh160tuku/q/%C7%E0%B4%BA%CB%AE%C7%F2%C9%E7_14981/%B5%DA2%BB%B0_223723/00"+i+".jpg";
            }
            picList.add(picHead);
            i++;
        }
        Download(picList);
    }
    private static void Download(List<String> listImgSrc) {
        try {
            for (String url : listImgSrc) {
                String imageName = "F:\\文档\\pic\\waterball\\02\\"+url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) uri.
                        openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                InputStream in = connection.getInputStream();

                FileOutputStream fo = new FileOutputStream(new File(imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
            }
        } catch (Exception e) {
            System.out.println("下载失败");
            e.printStackTrace();
        }
    }
}
