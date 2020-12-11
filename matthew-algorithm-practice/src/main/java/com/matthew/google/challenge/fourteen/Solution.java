package com.matthew.google.challenge.fourteen;


import org.junit.Assert;

/**
 * @author : matthew
 * @description :
 * @date : 2020/11/10 1:46 下午
 *
 *最长公共前缀
 *
 **/
public class Solution {
    /**
     * 纵向扫描
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null ||strs.length == 0 ){
            return "";
        }
        String firstStr = strs[0];
        if(strs.length == 1 ||"".equals(firstStr)){
            return firstStr;
        }
        for(int i=0;i<firstStr.length();i++){
            char c =firstStr.charAt(i);
            for(String str:strs){
                if(str.length()==i|| str.charAt(i)!=c){
                    return str.substring(0,i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 横向扫描
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower","flow","flight"};
        String[] strs2 = new String[]{"dog","racecar","car"};
        String[] strs3 = new String[]{};
        String[] strs4 = new String[]{"dog"};
        String[] strs5 = new String[]{"flower","flower","flower","flower"};
        Assert.assertEquals("fl",longestCommonPrefix(strs1));
        Assert.assertEquals("",longestCommonPrefix(strs2));
        Assert.assertEquals("",longestCommonPrefix(strs3));
        Assert.assertEquals("dog",longestCommonPrefix(strs4));
        Assert.assertEquals("flower",longestCommonPrefix(strs5));
    }
}
