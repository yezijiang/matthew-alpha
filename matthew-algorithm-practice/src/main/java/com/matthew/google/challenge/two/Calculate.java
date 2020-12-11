package com.matthew.google.challenge.two;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-18 12:33
 */
public class Calculate {
	public String[] inputString = new String[10];

	/**
	 * 将中缀表达式转化为前缀表达式
	 *
	 *
	 * 1，首先将删除符号清除
	 * 2，如果是数字直接放入changedStrings，
	 * 3，如果是字符则压入栈
	 * 				1，{当前运算符}优先级小于等于{栈顶运算符}，弹出{栈顶运算符}，再将{当前运算符}压入栈。
	 * 			    2，当前运算符优先级栈顶运算符，弹出栈顶，
	 * 			    3，如果遇到左括号，则将其压入栈
	 * 			    4，栈顶的运算符依次弹出并输出，直至遇到左括号
	 */
	public void transToAfterExp(){
		StringStack stack = new StringStack();//运算符栈
		String[] changedStrings = new String[10];
		for(int i=0;i<inputString.length;i++){

		}
	}

	/**
	 * 读取后缀表达式并进行计算
	 * 1，从左向右读取，
	 * 2，如果是数字则压住栈
	 * 3，如果是运算符，则弹出a,再弹出b作为数字，进行 {b 运算符操作 a}，然后将结果压入操作数栈
	 *
	 * @param changedStrings
	 * @return
	 */
	public Double calTheAlterExp(String[] changedStrings){
		StringStack stack = new StringStack();//操作数栈
		for(int i=0;i<inputString.length;i++){

		}
		return 0.00d;
	}

	public void printStringArray(String[] strings){

	}
	@Test
	public void testAlgorithm(){
		inputString = new String[]{"2","*","9",""};
	}
}
