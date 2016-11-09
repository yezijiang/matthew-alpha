package com.matthew.designPattern.proxy;

/**具体查询类 充当真实主题角色，他实现了查询功能，提供方法doSearch()来查询信息。
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 17:06
 */
public class RealSearcher {
    public String doSearch(String userId,String keyword){
        System.out.println("用户"+userId+"使用关键词"+keyword+"查询商务信息。");
        return "返回具体内容";
    }
}
