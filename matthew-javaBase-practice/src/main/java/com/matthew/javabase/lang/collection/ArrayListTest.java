package com.matthew.javabase.lang.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-28 9:29
 * 使用for语句直接删除arraylist中的某个数据，for循环删除会导致问题，
 * 了解remove的源码，数组左移（System.arraycopy(elementData, index+1, elementData, index,numMoved);），就可以了
 * 正确用法可以倒叙删除或者用iterator。
 *
 *
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //错误用法，如果
        List<String> list = new ArrayList<>(Arrays.asList("a","a","a","c","d","e"));
        for (String a:list) {
            System.out.println(a);
        }
        for (int i=0;i<list.size();i++){
            if("a".equals(list.get(i))){
                list.remove(i);
            }
        }
        //如果用Stream该如何使用
        List<String> filtered = list.stream().filter(string->!"a".equals(string)).collect(Collectors.toList());
        filtered.forEach(System.out::print);
    }
}
