package com.matthew.google.challenge.nine;

import org.junit.Assert;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-26 10:24
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 * 不将一个数转化为字符串，判断一个数是否为回文数。
 * 将正整数翻转
 */
public class Palindrome {
	public static boolean isPalindrome(int x){
		if(x < 0) return false;
		if(x == 0) return true;
		long reverse = 0;
		long inputx = x;
		while(inputx!=0){
			long pop = inputx%10;
			reverse = reverse*10+pop;
			inputx = inputx/10;
		}
		return reverse == x;
	}

	public static void main(String[] args) {
		Assert.assertEquals(true,isPalindrome(0));
		Assert.assertEquals(false,isPalindrome(-123));
		Assert.assertEquals(true,isPalindrome(121));
		Assert.assertEquals(false,isPalindrome(1888888888));
	}


}
