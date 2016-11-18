package com.matthew.designPattern.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-26 14:43
 */
public class SimpleFactory {


    public static void main(String args[]){
        SimpleFactory sfactory = new SimpleFactory();
        Shape circle = null;
        try {
            circle = (Shape) XmlUtil.getInstant("circle");
            circle.draw();
            circle.erase();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            Shape ellipse = (Shape) XmlUtil.getInstant("ellipse");
//            if(ellipse == null)  new UnSupportedShapeException("不存在此类型");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
