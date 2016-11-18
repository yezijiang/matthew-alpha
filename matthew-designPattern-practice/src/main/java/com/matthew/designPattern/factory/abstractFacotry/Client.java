package com.matthew.designPattern.factory.abstractFacotry;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-29 11:30
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("开始构建按钮相关");
        XmlUtil xmlUtil = new XmlUtil();
        SkinFactory skinFactory = (SkinFactory) xmlUtil.getBean();
        skinFactory.getButton().display();
        skinFactory.getComboBox().display();
        skinFactory.getTextField().display();

    }
}
