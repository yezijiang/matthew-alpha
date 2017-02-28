/** 
 * Project Name:mypractice 
 * File Name:TxtRead.java 
 * Package Name:com.yaoyoahao.io 
 * Date:2016-1-5下午5:01:43 
 * Copyright (c) 2016, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.io;

import java.io.*;

public class TxtRead implements Serializable{
	private static final long serialVersionUID = 5170207209090338370L;
	private String fileName;
	public static void main(String args[]){
		try {
			FileOutputStream book105 = new FileOutputStream(new File("G:/duomi/101.dat"));
			TxtRead txtRead= new TxtRead();
			ObjectOutputStream bood105Obj = new ObjectOutputStream(book105);
			bood105Obj.writeObject(txtRead);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
