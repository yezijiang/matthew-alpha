package com.matthew.google.challenge.slidingWindow;

import com.matthew.google.challenge.priorityQueue.Solution703;
import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 * @author : matthew
 * @description :
 * @date : 2020/12/23 4:43 下午
 **/
public class Solution239{

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length*k <= 0)return new int[0];
        if(k==1)return nums;
        if(k>=length) return new int[]{maxArray(nums,0,nums.length)};

        int retSize = length-k+1;
        int[] output = new int[retSize];
        
        return output;
    }

    /**
     * 暴力流
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length*k <= 0)return new int[0];
        if(k==1)return nums;
        if(k>=length) return new int[]{maxArray(nums,0,nums.length)};

        int retSize = length-k+1;
        int[] output = new int[retSize];
        for(int i=0;i<retSize;i++){
            output[i] = maxArray(nums,i,i+k);
        }
        return output;
    }**/
    private static int maxArray(int[] nums,int start,int end){
        int curValue=nums[start];
        for(int i=start;i<end;i++){
            curValue = Math.max(curValue, nums[i]);
        }
        return curValue;
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 1,3,-1,-3,5,3,6,7 };
        int[] ret = maxSlidingWindow(nums,3);
         Assert.check(Arrays.equals(ret,new int[] { 3,3,5,5,6,7}));

        int[] nums2 = new int[] { 1};
        int[] ret2 = maxSlidingWindow(nums2,2);
        Assert.check(Arrays.equals(ret2,new int[] { 1}));

        int[] nums3 = new int[] { 7,2,4};
        int[] ret3 = maxSlidingWindow(nums3,2);
        Assert.check(Arrays.equals(ret3,new int[] { 7,4}));


    }
}
