package com.matthew.designPattern.proxy;

/**
 * 抽象搜索类，抽象主题角色，声明了doSearch()方法。
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 17:05
 */
public interface Searcher {
    public String doSearch(String userId,String keyword);
}
