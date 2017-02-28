package com.matthew.javabase.rpc.niostudy.chapterOne;

import sun.io.CharToByteUnicode;

import java.nio.CharBuffer;

/**
 * Buffer fill/drain example. The cod uses the simplest means of filling and
 * draining a buffer: one element at a time.
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-02 11:47
 */
public class BufferFillDrain {
    public static int index =0;
    public static String[] strings ={
            "A random string value",
            "The product of an indinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for Monkees:Jimi Hendrix",
            "Scuse me while I kiss this fly",
            "help Me! Help Me!",
    };
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(100);
        while(fillBuffer(buffer)){
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }
    private static void drainBuffer(CharBuffer buffer){
        while(buffer.hasRemaining()){
            System.out.print(buffer.get());
        }
        System.out.println("");
    }
    private static boolean fillBuffer(CharBuffer buffer){
        if(index >= strings.length){
            return false;
        }
        String string = strings[index++];
        for(int i=0;i< string.length();i++) {
            buffer.put(string.charAt(i));
        }
        return true;
    }
}

