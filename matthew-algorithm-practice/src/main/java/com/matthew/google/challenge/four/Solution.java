package com.matthew.google.challenge.four;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-20 14:14
 */
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 ){
			return findMedianSortedArray(nums2,nums2.length);
		}
		if(nums2 == null || nums2.length ==0){
			return findMedianSortedArray(nums1,nums1.length);
		}
		int maxValue = nums1[nums1.length-1] + nums2[nums2.length-1];

		int[] wholeNums = new int[maxValue];
		for(int i=0;i<nums2.length;i++){
			wholeNums[nums1[i]]= nums1[i];
		}
		for(int i=0;i<nums2.length;i++){
			wholeNums[nums2[i]]= nums2[i];
		}
		//偶数个
		int halfmaxValue = maxValue/2;
		if((nums1.length+nums2.length)%2 ==0){
			for(int i=halfmaxValue;i>=0;i--){

			}
		//奇数个
		}else{
			for(int i=halfmaxValue;i>=0;i--){
				if(wholeNums[halfmaxValue]!=0){
					return wholeNums[halfmaxValue];
				}
				if(wholeNums[halfmaxValue]!=0){
					return wholeNums[halfmaxValue];
				}
			}

		}

		return 0.00d;
	}
	public Double findMedianSortedArray(int[] nums,int length){
		if(length%2 ==0){
			return (Double.valueOf(nums[nums.length/2-1])+Double.valueOf(nums[nums.length/2]))/2;
		}else{
			return Double.valueOf(nums[nums.length/2]);
		}
	}

	public static void main(String[] args) {
		int[] wholeNums = new int[2];
		System.out.println(wholeNums);
	}
}
