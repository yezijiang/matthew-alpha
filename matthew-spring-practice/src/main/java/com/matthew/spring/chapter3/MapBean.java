package com.matthew.spring.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * 关于spring注入类型为map的练习
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-08 15:15
 */
public class MapBean {
    private Map<String,String> keyValues;

    public Map<String, String> getKeyValues() {
        return keyValues;
    }
    public void setKeyValues(Map<String, String> keyValues) {
        this.keyValues = keyValues;
    }

}
