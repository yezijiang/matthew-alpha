package com.matthew.google.challenge.list;

import com.sun.tools.javac.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : matthew
 * @description :
 * @date : 2020/12/11 2:13 下午
 **/
public class Solution141 {
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet();
        ListNode cur = head;
        while(cur != null){
            if(nodeSet.contains(cur)){
                return Boolean.TRUE;
            }
            nodeSet.add(cur);
            cur = cur.next;

        }
        return Boolean.FALSE;

    }


    /**
     * 双指针之快慢指针
     * 双指针可以解决链表的很多问题
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            fast = fast.next;

            if(fast != null && fast.next !=null){
                fast = fast.next;
            }
            if(fast == slow){
                return Boolean.TRUE;
            }
            slow = slow.next;
        }
        return Boolean.FALSE;

    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        Assert.check(!hasCycle2(one));
    }



    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
