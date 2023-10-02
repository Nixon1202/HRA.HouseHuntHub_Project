package com.Practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;

public class PropertyFile {

	public static void main(String[] args) throws Throwable {
		//step: obecjt respresntation of physical file
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties pObj = new Properties();
		
		pObj.load(fil);
        
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String LOGINURL = pObj.getProperty("loginurl");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(LOGINURL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}

}

