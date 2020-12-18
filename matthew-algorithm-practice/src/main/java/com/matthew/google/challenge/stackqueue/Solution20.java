package com.matthew.google.challenge.stackqueue;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-27 9:41
 */
public class Solution20 {
    public static boolean isValid(String s) {
        /**
         * 如果是奇数一定false
         */
        int n = s.length();
        if(n%2!=0){return Boolean.FALSE;}

        Stack<Character> stack = new Stack<>();
        Map<Character,Character> bracketMap = new HashMap<>();
        bracketMap.put(')','(');
        bracketMap.put('}','{');
        bracketMap.put(']','[');

        for(Character c : s.toCharArray()){

            if( bracketMap.keySet().contains(c)){
                if(!stack.isEmpty()&&stack.peek().equals(bracketMap.get(c))){
                    stack.pop();
                }else{
                    return Boolean.FALSE;
                }
            }else{
                stack.push(c);
            }

        }
        if(stack.empty()){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }


    /**
     * 不使用map
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        /**
         * 如果是奇数一定false
         */
        int n = s.length();
        if(n%2!=0){return Boolean.FALSE;}

        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){

            if('('==c){
                stack.push(')');
            }else if('{'==c){
                stack.push('}');
            }else if('['==c){
                stack.push(']');
            }else if(stack.isEmpty() || c!=stack.pop()){
                  return Boolean.FALSE;
            }
        }
        if(stack.empty()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 采用循环替换的方式，代码更简洁，但是时间复杂度比价高 是（n/2）^2
     * @param s
     * @return
     */
    public static boolean isValid3(String s) {
        int length ;
        do{
            length = s.length();
            s = s.replace("{}","").replace("()","").replace("[]","");
        }while (length != s.length());

        if(s.length()==0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;


    }

    public static void main(String[] args) {
        isValid("]");
    }
}
