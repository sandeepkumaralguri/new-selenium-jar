package org.wtt.docker.listener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("all")	
public class PropertiesUtility {
	
	    public static Properties properties;
     	public static Properties loadProperties(String path) {
     
		Properties properties=new Properties();
		try (FileInputStream st=new FileInputStream(path)){
			properties.load(st);
			setProperies(properties);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

		public static Properties getProperies() {
			return properties;
		}

		public static void setProperies(Properties properies) {
			PropertiesUtility.properties = properies;
		}

		
     public static Properties loadApplicationProperties() throws IOException {
   		Properties properties = new Properties();
  		properties.load(ClassLoader.getSystemResourceAsStream("src/test/resources/application.properties"));
  		setProperies(properties);
  		System.out.println(properties.get("es.path"));
     	 return properties;
    	 
     }
     
 

}
