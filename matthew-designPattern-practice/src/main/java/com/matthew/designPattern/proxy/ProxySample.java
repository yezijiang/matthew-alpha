package com.matthew.designPattern.proxy;

/**
 * 本实例是保护代理和智能引用代理的应用实例，
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-21 17:35
 */
public class ProxySample {
    public static void main(String[] args) {
        Searcher searcher = new ProxySearcher();
        searcher.doSearch("杨过","玉女心经");
    }

}
