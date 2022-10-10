package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	
	//This class will have method to read data from property file
	
	public static String readData(String filename,String value) {
		Properties prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Config\\"+filename);//reading the file (java class)
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		return prop.getProperty(value);
		
	}

}
