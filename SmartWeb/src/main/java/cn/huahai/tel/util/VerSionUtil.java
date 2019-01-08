package cn.huahai.tel.util;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;   
import org.w3c.dom.NodeList; 
public class VerSionUtil {
	
	

	public String getVersion(String xml) {
		try {
			


			///SmartWeb/pom.xml
			File file = new File(xml);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);   
			NodeList nl = doc.getElementsByTagName("version"); 
			int a = nl.getLength()-1;
			String version=nl.item(a).getFirstChild().getNodeValue();
				
			
			return version;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	
		
	}
	
	
	

}
