package com.matthew.javabase.lang.collection;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-05-17 10:47
 */
public class LinkedHashMapTest {
    @Test
    public void testPut(){
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("111","11111");
        linkedHashMap.put("222","22222");
        linkedHashMap.put("333","33333");
        linkedHashMap.put("444","44444");
        linkedHashMap.put("555","55555");
        //迭代key
        Iterator<Map.Entry>  iterator= linkedHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());

        }
    }
}
