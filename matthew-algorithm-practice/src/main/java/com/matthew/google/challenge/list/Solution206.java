package com.matthew.google.challenge.list;

/**
 * @author : matthew
 * @description :
 * @date : 2020/12/9 3:10 下午
 **/
public class Solution206 {
    public static ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while(null != pre){

            ListNode temp = pre.next;
            pre.next =cur;
            cur = pre;
            pre = temp;
        }

        return cur;

    }
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        reverseList(one);
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
