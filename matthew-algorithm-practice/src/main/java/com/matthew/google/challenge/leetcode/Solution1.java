package com.matthew.google.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : matthew
 * @description :
 * @date : 2023/2/22 下午4:11
 **/
public class Solution1 {
    /**
     * 暴力
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i =0; i<nums.length;i++){
            for(int j =i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }

    /**
     * 第二次循环使用hashmap将O(n)降低到O（1）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(tempMap.containsKey(target-nums[i])){
               return new int[]{i,tempMap.get(target-nums[i])};
            }
            tempMap.put(nums[i],i);
        }
        return null;
    }

}
