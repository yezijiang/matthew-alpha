package com.matthew.javabase.lang.genericity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-25 15:35
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random random = new Random(44);

    public void add(T item){
        storage.add(item);
    }
    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }
    public static void main(String[] args) {
        RandomList<String> rl = new RandomList<String>();
        for(String s:"apple orange pinch watermalen".split(" ")){
            rl.add(s);
        }
        for(int i=0;i<10;i++){
            System.out.println(rl.select());
        }
    }
}
