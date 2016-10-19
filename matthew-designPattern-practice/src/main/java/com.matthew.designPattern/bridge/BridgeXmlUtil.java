package com.matthew.designPattern.bridge;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-19 11:26
 */
public class BridgeXmlUtil {
    public static Object getBean(String args){
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(BridgeXmlUtil.class.getResourceAsStream("/config/bridgebean.xml"));

            NodeList nodeList = doc.getElementsByTagName(args);
            Node firstNode =  nodeList.item(0).getFirstChild();
            Class clazz = Class.forName(firstNode.getTextContent());
            return clazz.newInstance();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Image image = (com.matthew.designPattern.bridge.Image) BridgeXmlUtil.getBean("imageType");
        ImageImp imageimp = (com.matthew.designPattern.bridge.ImageImp) BridgeXmlUtil.getBean("operationSystem");
        image.setImageImp(imageimp);
        image.parseFile("小龙女");
    }
}
