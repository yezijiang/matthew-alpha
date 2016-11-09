package com.matthew.designPattern.adapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-18 16:07
 */
public class XmlUtil {
    public  void getBean(){
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc=null;
            doc = builder.parse(this.getClass().getResourceAsStream("/config/adapterbean.xml"));

            NodeList nodeList =  doc.getElementsByTagName("className");
            Element firstElement = (Element) nodeList.item(0);
            System.out.println(firstElement.getTextContent());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlUtil xmlUtil = new XmlUtil();
        xmlUtil.getBean();
    }
}
