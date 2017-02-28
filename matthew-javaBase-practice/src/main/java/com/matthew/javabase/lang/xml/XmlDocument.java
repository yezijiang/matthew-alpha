package com.matthew.javabase.lang.xml;
/**
 * 
 * @ClassName:  XmlDocument   
 * @Description:定义XML文档建立与解析的接口   
 * @author maxing
 * @date:   2015-12-28 上午11:16:24   
 *
 */
public interface XmlDocument {
	/**
	 * @Title:	createXml
	 * @Description: 	建立XML文档 
	 * @param fileName  void  
	 * @author maxing
	 * @date 2015-12-28 上午11:18:41
	 */
	public void createXml(String fileName);
	/**
	 * 
	 * @Title:	parseXml
	 * @Description: 	解析Xml文档
	 * @param fileName  void  
	 * @author maxing
	 * @date 2015-12-28 上午11:19:20
	 */
	public void parseXml(String fileName);
}
  