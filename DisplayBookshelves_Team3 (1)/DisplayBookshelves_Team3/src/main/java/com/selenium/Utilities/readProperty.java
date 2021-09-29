package com.selenium.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readProperty {
public static String getKey(String key) throws Exception {
		
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\projectConfig.properties");
		FileInputStream fileInputStream;
		fileInputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String property = properties.getProperty(key);
		return property;
	}
}
