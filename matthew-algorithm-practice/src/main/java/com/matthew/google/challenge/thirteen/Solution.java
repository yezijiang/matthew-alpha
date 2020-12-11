package com.matthew.google.challenge.thirteen;

import com.google.common.base.Strings;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-27 9:42
 * Roman to Integer
 * 将一个罗马数字转化为证书
 */
public class Solution {
	public int romanToInt(String s) {
		Map<String,Integer> romanSymbol = new HashMap<String,Integer>();
		romanSymbol.put("I",1);
		romanSymbol.put("V",5);
		romanSymbol.put("X",10);
		romanSymbol.put("L",50);
		romanSymbol.put("C",100);
		romanSymbol.put("D",500);
		romanSymbol.put("M",1000);
		String temRomStr = "";
		char[] sArrays = s.toCharArray();
		int sum = 0;
		for(int i=0;i<sArrays.length;i++){
			if(!"".equals(temRomStr)){
				if(romanSymbol.get(temRomStr) < romanSymbol.get(""+sArrays[i])){
					sum = sum + romanSymbol.get(""+sArrays[i]) - romanSymbol.get(temRomStr);
					temRomStr = "";
				}else{
					sum = sum + romanSymbol.get(temRomStr);
					temRomStr = ""+sArrays[i];
				}
			}else{
				temRomStr = ""+sArrays[i];
			}
		}
		if(!"".equals(temRomStr)){
			sum = sum + romanSymbol.get(temRomStr);
		}
		return sum;
	}

	/**
	 * 解题思路是
	 * 1，如果前一个字符小于后一个字符，则前一个字符为-
	 * 2，否则为正，再考虑溢出情况就好了。
	 * @param s
	 * @return
	 */
	public int romanToInt2(String s) {
		Map<String,Integer> romanSymbol = new HashMap<String,Integer>();
		romanSymbol.put("I",1);
		romanSymbol.put("V",5);
		romanSymbol.put("X",10);
		romanSymbol.put("L",50);
		romanSymbol.put("C",100);
		romanSymbol.put("D",500);
		romanSymbol.put("M",1000);
		String temRomStr = "";
		char[] sArrays = s.toCharArray();
		int sum = 0;
		int size =sArrays.length-1;
		for(int i=0;i<=size;i++){
			if(i==size){
				sum +=romanSymbol.get(sArrays[i]+"");
				return sum;
			}
			if(romanSymbol.get(sArrays[i]+"")>=romanSymbol.get(sArrays[i+1]+"")){
				sum +=romanSymbol.get(sArrays[i]+"");
			}else{
				sum -=romanSymbol.get(sArrays[i]+"");
			}
		}
		return sum;
	}


	/**
	 * 解题思路是
	 * 1，如果前一个字符小于后一个字符，则前一个字符为-
	 * 2，否则为正，再考虑溢出情况就好了。
	 * 网上思路，不转str，不用hashmap
	 * @param s
	 * @return
	 */
	public int romanToInt3(String s) {
		int sum = 0;
		int preNum = getValue(s.charAt(0));
		for(int i=1;i<s.length();i++){
			int num = getValue(s.charAt(i));
			if(num>preNum){
				sum-=preNum;
			}else{
				sum+=preNum;
			}
			preNum = num;
		}
		sum += preNum;
		return sum;
	}
	private int getValue(char ch) {
		switch(ch) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

	@Test
	public void testValue(){
		Assert.assertEquals(1,romanToInt3("I"));
		Assert.assertEquals(4,romanToInt("IV"));
		Assert.assertEquals(9,romanToInt("IX"));
		Assert.assertEquals(58,romanToInt("LVIII"));
		Assert.assertEquals(1994,romanToInt("MCMXCIV"));

	}
}
