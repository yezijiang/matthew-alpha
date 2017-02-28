/** 
 * Project Name:mypractice 
 * File Name:Dom4jDemo.java 
 * Package Name:com.yaoyaohao.xml 
 * Date:2015-12-29下午3:55:11 
 * Copyright (c) 2015, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public class Dom4jDemo implements XmlDocument {   
	public void createXml(String fileName) {   
		Document document = DocumentHelper.createDocument();   
		Element employees=document.addElement("employees");   
		Element employee=employees.addElement("employee");   
		Element name= employee.addElement("name");   
		name.setText("ddvip");   
		Element sex=employee.addElement("sex");   
		sex.setText("m");   
		Element age=employee.addElement("age");   
		age.setText("29");   
		try {   
			Writer fileWriter=new FileWriter(fileName);   
			XMLWriter xmlWriter=new XMLWriter(fileWriter);   
			xmlWriter.write(document);   
			xmlWriter.close();   
		} catch (IOException e) {   
			System.out.println(e.getMessage());   
		}   
	}

	@Override
	public void parseXml(String fileName) {
		File inputXml=new File(fileName);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element employees=document.getRootElement();
			for(Iterator i = employees.elementIterator(); i.hasNext();){
				Element employee = (Element) i.next();
				for(Iterator j = employee.elementIterator(); j.hasNext();){
					Element node=(Element) j.next();
					System.out.println(node.getName()+":"+node.getText());
				}
			}
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("dom4j parserXml");
	} 
}