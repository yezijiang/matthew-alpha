/** 
 * Project Name:mypractice 
 * File Name:JdomDemo.java 
 * Package Name:com.yaoyaohao.xml 
 * Date:2015-12-30上午11:05:33 
 * Copyright (c) 2015, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang.xml;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JdomDemo implements XmlDocument{

	@Override
	public void createXml(String fileName) {
		Document document;   
		Element  root;   
		root=new Element("employees");   
		document=new Document(root);   
		Element employee=new Element("employee");   
		root.addContent(employee);   
		Element name=new Element("name");   
		name.setText("ddvip");   
		employee.addContent(name);   
		Element sex=new Element("sex");   
		sex.setText("m");   
		employee.addContent(sex);   
		Element age=new Element("age");   
		age.setText("23");   
		employee.addContent(age);   
		XMLOutputter XMLOut = new XMLOutputter();   
		try {   
			XMLOut.output(document, new FileOutputStream(fileName));   
		} catch (FileNotFoundException e) {   
			e.printStackTrace();   
		} catch (IOException e) {   
			e.printStackTrace();   
		}   


	}

	@Override
	public void parseXml(String fileName) {
		SAXBuilder builder=new SAXBuilder(false);    
		try {   
			Document document=builder.build(fileName);   
			Element employees=document.getRootElement();    
			List employeeList=employees.getChildren("employee");   
			for(int i=0;i<employeeList.size();i++){
				Element employee=(Element)employeeList.get(i);   
				List employeeInfo=employee.getChildren();   
				for(int j=0;j<employeeInfo.size();j++){
					System.out.println(((Element)employeeInfo.get(j)).getName()+":"+((Element)employeeInfo.get(j)).getValue());   
				}   
			}   
		} catch (JDOMException e) {   
			e.printStackTrace();   
		} catch (IOException e) {   
			e.printStackTrace();   
		} 	
	}

}
  