package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Dk
 *
 */

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on keywhich you pass as an argument
	 * @param key
	 * @return String
	 * @throws Throwable
	 * 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis= new FileInputStream("./data1/commondata.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	
	}

}
