/** 
 * Project Name:mypractice 
 * File Name:MagicCircle.java 
 * Package Name:com.yaoyaohao.eleganceCode.one 
 * Date:2016-2-16下午4:02:47 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang.eleganceCode;

public class MagicCircle {
	/**
	 * 题目：
	 * size = 5 
		1	2	3	4	5	
		16	17	18	19	6	
		15	24	25	20	7	
		14	23	22	21	8	
		13	12	11	10	9 
	 */
	
	private int[][] circleNumber;
	private int size;
	private int n =1;
	
	public MagicCircle(int size){  
		this.size = size;  
	    circleNumber = new int[size][size];  
	} 
	public static void main(String args[]){
		MagicCircle demo = new MagicCircle(5);
	    demo.draw();  
	    demo.print(); 
		
	}
	public void print(){
		for(int[] arrayNumber:circleNumber){
			for(int number:arrayNumber){
				if(number<10){
					System.out.print("0"+number+"|");
				}else{
					System.out.print(number+"|");
				}
				
			}
			System.out.println();
		}
	}
	public void draw(){
		assemble(0); 
	}
	//对行为的固定逻辑的抽取一个圈为一个轮回。
	public void assemble(int start){
		int end = size-start;
		for(int i=start;i<end;i++){
			System.out.println(n);
			circleNumber[start][i]=n++;
		}
		if(start + 1 >= end ){  
            return;  
        }  
		for(int i=start+1;i<end;i++){
			System.out.println(n);
			circleNumber[i][end -1]=n++;
		}
		
		for(int i=end -2;i>=start;i--){
			System.out.println(n);
			circleNumber[end -1][i]=n++;
		}
		for(int i=end -2;i>=start+1;i--){
			System.out.println(n);
			circleNumber[i][start]=n++;
		}
        assemble(start+1);    
	}
}
  