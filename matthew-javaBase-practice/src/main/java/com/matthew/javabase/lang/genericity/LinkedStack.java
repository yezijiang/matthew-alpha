package com.matthew.javabase.lang.genericity;

/**一个堆栈类
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-25 14:23
 */
public class LinkedStack<T> {
    public static class Node<T>{
        T item;
        Node<T> next;
        public  Node(T item,Node<T> next){
            this.item = item;
            this.next = next;
        }
        public  Node(){
            this.item = null;
            this.next = null;
        }
        public boolean end(){
            return next ==null;
        }
    }
    private Node<T> top = new Node<T>();
    public void pup(T item){
        top = new Node<T>(item,top);
    }
    public T pop(){
        T temp = top.item;
        if(!top.end()) top = top.next;
        return temp;
    }
    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<String>();
        for(String s:"Phasers on stun".split(" ")){
            ls.pup(s);
        }
        String s ;
        while((s =ls.pop()) !=null){
            System.out.println(s);
        }
    }
}
