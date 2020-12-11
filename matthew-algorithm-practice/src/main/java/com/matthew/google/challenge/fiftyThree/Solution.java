package com.matthew.google.challenge.fiftyThree;

/**
 * @author : matthew
 * @description :
 * @date : 2020/11/9 2:04 下午
 **/
public class Solution {
    public int maxSubArray(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else{
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution Solution = new Solution();
        int[] nums ={-2,3,-1,1,-3};
        int ans = Solution.maxSubArray(nums);
        System.out.println(ans);
    }

}
