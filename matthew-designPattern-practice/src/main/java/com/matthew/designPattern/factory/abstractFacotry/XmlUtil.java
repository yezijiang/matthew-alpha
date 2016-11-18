package com.matthew.designPattern.factory.abstractFacotry;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-29 14:39
 */
public class XmlUtil {
    public  Object getBean(){
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = null;
        try {
            dbuilder = dbfactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        SkinFactory factoryInstance = null;
        try {
            Document doc= dbuilder.parse(this.getClass().getResourceAsStream("/config/factory.xml"));
            NodeList nodeList = doc.getElementsByTagName("className");
            Element firstNode = (Element) nodeList.item(0);
            factoryInstance = (SkinFactory) Class.forName(firstNode.getTextContent()).newInstance();

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factoryInstance;
    }

    public static void main(String[] args) throws ParserConfigurationException {
        final int a = 1<<2;
        System.out.println(a);
    }
}
