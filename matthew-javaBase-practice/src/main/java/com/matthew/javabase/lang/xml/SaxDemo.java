/** 
 * Project Name:mypractice 
 * File Name:SaxDemo.java 
 * Package Name:com.yaoyaohao.xml 
 * Date:2015-12-29下午3:15:45 
 * Copyright (c) 2015, maxing All Rights Reserved. 
 * 药药好（杭州）网络科技有限公司
*/  
  
package com.matthew.javabase.lang.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SaxDemo implements XmlDocument{
	public void createXml(String fileName) {
		System.out.println("<<"+fileName+">>");
	}
	public void parseXml(String fileName) {
		SAXParserFactory saxfac = SAXParserFactory.newInstance();
		try {
			SAXParser saxparser = saxfac.newSAXParser();
			InputStream is = new FileInputStream(fileName);
			saxparser.parse(is, new MySAXHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MySAXHandler extends DefaultHandler {
	boolean hasAttribute = false;
	Attributes attributes = null;
	
	public void startDocument() throws SAXException {
		System.out.println("文档开始打印了");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("文档打印结束了");
	}
	
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
		if (qName.equals("employees")) {
			return;
		}
		if (qName.equals("employee")) {
			System.out.println(qName);
		}
		if (attributes.getLength() > 0) {
			this.attributes = attributes;
			this.hasAttribute = true;
		}
	
	}
	
	public void endElement(String uri, String localName, String qName)throws SAXException {
		if (hasAttribute && (attributes != null)) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println(attributes.getQName(0)+ attributes.getValue(0));
			}
		}
	}
	
	public void characters(char[] ch, int start, int length)throws SAXException {
		System.out.println(new String(ch, start, length));
	}
}

class TestSaxHandler extends DefaultHandler{


	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub  
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub  
		super.endDocument();
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub  
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub  
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub  
		super.characters(ch, start, length);
	}

}
  