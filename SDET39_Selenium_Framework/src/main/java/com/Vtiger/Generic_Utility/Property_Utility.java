package com.Vtiger.Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility 
{
/**
 * 	This method is used to match the speed of selenium with the aplication Or waits for page to load before identifying any synchronized element in DOM
 * @author nikita 
 */
	public String getPropertyKeyValue(String Key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./CommonProperties.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(Key);
		return value;
		
				
		
	}

}
