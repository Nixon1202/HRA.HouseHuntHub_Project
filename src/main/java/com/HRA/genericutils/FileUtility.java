package com.HRA.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of methods to fetch common data from property file
 * @author Nixon
 */

public class FileUtility {
	
	/**
	 * This method is used to fetch common data present inside the property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream(IPathconstants.propertyFilePath);
		Properties prop = new Properties();
		prop.load(fileInputStream);
		return prop.getProperty(key);
	}

}
