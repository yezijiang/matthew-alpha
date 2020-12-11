package com.matthew.google.challenge.list;

import java.util.List;

/**
 * @author : matthew
 * @description :
 * @date : 2020/12/9 3:20 下午
 **/
public class Solution24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode ret = head;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null && cur.next != null ){
            ListNode temp =  cur.next.next;
            if(null == next){
                ret=cur.next;
            } else{
              next.next=  cur;
            }
            next = cur.next;

            cur.next = temp;
            next.next = cur;

            cur=temp;

        }



        return   ret;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next =four;
        swapPairs(one);
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

