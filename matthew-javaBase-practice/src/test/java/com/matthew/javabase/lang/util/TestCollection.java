package com.matthew.javabase.lang.util;

import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-01 13:37
 */
public class TestCollection {
    /**
     * HashSet 是封装了HashMap进行存储元素的，
     * Set是无需的，不可重复的集合
     * set的获取考数组或迭代器。
     */
    //@Test
    public void testSet(){
        HashSet fruits = new HashSet<String>();
        fruits.add("apple");
        fruits.add("peach");
        Object[] fruitsStringArray =fruits.toArray();
        System.out.println((String)fruitsStringArray[0]+(String)fruitsStringArray[1]);
        Iterator fruitsIterator= fruits.iterator();
        while (fruitsIterator.hasNext()){
            System.out.println((String) fruitsIterator.next());
        }
    }

    /**
     *  KeySet这个类并不是真正意义上的Set集合，它并没有真正实现Set接口的所有函数，只是提供了一个Iterator ，所以他的用处只是用来遍历，
     *  而他的iterator()函数最终却是由KeyIterator来实现，而KeyIterator是对HashMap的HashMapEntry<K, V>[] table来进行迭代遍历的，
     *  所以其实说到这看起来 KeySet 本身什么都没做。
     *  回到开始的一句话 ，KeySet本身不是真正意义上Set集合，不像HashSet有自己的存储变量空间。它的作用主要是用来提供对key的迭代操作。
     *  有点像用了代理模式，代理了KeyIterator类 ，当然KeySet也提供了一些其他基本操作，但真正实现都是调用HashMap实现。
     *  看到这KeySet类就像把对key的操作进行了封装，而具体实现全部由外部实现。
     */
    @Test
    public void testHashMap(){
        HashMap<String,String> stock = new HashMap();
        stock.put("apple","100");
        stock.put("peach","200");

        Set fruitNam = stock.keySet();
        Iterator fruitsIterator= fruitNam.iterator();
        while (fruitsIterator.hasNext()){
            System.out.println((String) fruitsIterator.next());
        }
    }
    public static void main(String[] args) {
        transform(64);
        transform(64+32+16);
        transform(1+2+4+8);
    }
    static void transform(int h){
        System.out.println(Integer.toBinaryString(h)+"-->"+Integer.toBinaryString(hash(h)));
    }
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
