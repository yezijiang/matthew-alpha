package com.matthew.designPattern.factory.factoryMethod;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-28 14:16
 */
public class XmlUtils {
    private  volatile boolean isinLoad = false;
    private Factory beanFactory;
    public void inloadXml(){
        if(!isinLoad){
            isinLoad = true;
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder= dbFactory.newDocumentBuilder();
                //不可用，在src.java不放置xml等配置文件，是maven的约定，所以this.getClass().getResourceAsStream("name")无用
                Document doc= documentBuilder.parse(this.getClass().getResourceAsStream("/config/factory.xml"));
                NodeList factoryClassList =doc.getElementsByTagName("className");
                //let us assume it just have one class
                Element factoryClass = (Element) factoryClassList.item(0);
                beanFactory = (Factory) Class.forName(factoryClass.getTextContent()).newInstance();
            } catch (Exception e) {
                isinLoad = false;
            }
        }

    }

    public Factory getBeanFactory(){
        inloadXml();
        beanFactory.createLogger().writeLog();
        return beanFactory;
    }

    public static void main(String[] args) {
        XmlUtils xmlUtils = new XmlUtils();
        xmlUtils.getBeanFactory();
    }

}
