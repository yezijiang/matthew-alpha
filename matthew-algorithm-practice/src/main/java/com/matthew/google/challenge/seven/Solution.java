package com.matthew.google.challenge.seven;

import com.google.common.math.BigIntegerMath;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-21 16:55
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class Solution {
	public int reverse(int x) {
		boolean markNegative = false;
		if(x<0){
			markNegative =true;
		}
		String stringInt = String.valueOf(x);
		int length =stringInt.length();
		char[] charNums = new char[length];
		int i=length-1;
		for (char charInt:stringInt.toCharArray()) {
			charNums[i] = charInt;
			i--;
		}
		String numString = new String(charNums);
		if(markNegative){
			numString = numString.substring(0,length-1);
			numString = "-"+numString;
		}
		Long returnVal = Long.parseLong(numString);
		if(returnVal > Integer.MAX_VALUE  || returnVal< Integer.MIN_VALUE ){
			return 0;
		}
		return Integer.parseInt(numString);

	}

	/**
	 * 使用弹出和推入数字的方法&溢出前进行检查
	 *  不使用stack，直接利用 pop=x/10 的方式弹出尾数
	 *  而使用retVal = 10*retVal+pop推入
	 *
	 * @param x
	 * @return
	 */
	public int reverse2(int x) {

		//首先考虑大于0的问题
		int retVal = 0;
		while (x!=0){
			int pop =x%10;
			x = x/10;
			if(retVal>Integer.MAX_VALUE/10||(retVal==Integer.MAX_VALUE&&pop>7))return 0;
			if(retVal<Integer.MIN_VALUE/10||(retVal==Integer.MIN_VALUE&&pop>-8))return 0;
			retVal = retVal*10+pop;
		}
		return retVal;
	}
	@Test
	public void TestReAlgorithm(){
		int a = 123;
		int b = -2147483648;
		int c = 0;
		int d = 1534236469;
		Assert.assertEquals(321,reverse2(a));
		Assert.assertEquals(0,reverse2(b));
		Assert.assertEquals(0,reverse2(c));
		Assert.assertEquals(0,reverse2(d));

	}

	public static void main(String[] args) {
		System.out.println(7%10);
		System.out.println(7/10);
		System.out.println(-71%10);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));


	}



}
