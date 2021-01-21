package com.matthew.google.challenge.priorityQueue;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : matthew
 * @description :
 * @date : 2020/12/18 10:55 上午
 *
 * 使用小顶堆，最小的值在最上面，每次取O(1)，插入O（logn）
 *
 *
 **/
public class Solution703 {
    private PriorityQueue<Integer> queue ;
    private Integer limit;
    public Solution703(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue(k);
        for(int num:nums){
            add(num);
        }
    }

    public int add(int val) {

            queue.add(val);

        return queue.peek();

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 8, 2 };
        Solution703 kthLargest = new Solution703(3, arr);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */