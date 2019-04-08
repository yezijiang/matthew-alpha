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
 * 将一个罗马数字转化为
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
	@Test
	public void testValue(){
		Assert.assertEquals(3,romanToInt("III"));
		Assert.assertEquals(4,romanToInt("IV"));
		Assert.assertEquals(9,romanToInt("IX"));
		Assert.assertEquals(58,romanToInt("LVIII"));
		Assert.assertEquals(1994,romanToInt("MCMXCIV"));

	}
}
