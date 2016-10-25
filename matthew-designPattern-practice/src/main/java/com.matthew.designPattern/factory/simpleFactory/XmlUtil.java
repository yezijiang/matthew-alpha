package com.matthew.designPattern.factory.simpleFactory;

import com.google.common.base.Strings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-26 14:25
 */
public class XmlUtil {
    public static HashMap<String,Object> beanHolder = new HashMap<String, Object>();
    public static int a = getInt();
    public static int getInt(){
        System.out.println("静态参数被调用");
        return 1;
    }
    static {
        System.out.println("satatic块被调用");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dbuilder =  dbfactory.newDocumentBuilder();
            Document doc =null;
            doc = dbuilder.parse(XmlUtil.class.getResourceAsStream("/config/beanConfig.xml"));
            System.out.println(XmlUtil.class.getClassLoader());
            NodeList beanList = doc.getElementsByTagName("bean");
            for(int i =0;i< beanList.getLength();i++){
                Element bean= (Element) beanList.item(i);
                beanHolder.put(bean.getAttribute("id"),Class.forName(bean.getAttribute("class")).newInstance());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Object getInstant(String className){
        System.out.println("static方法被调用");
        if(Strings.isNullOrEmpty(className)){
            throw new UnSupportedShapeException("不能为空");
        }
        return beanHolder.get(className);
    }
}
