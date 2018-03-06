package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropHandler {
	
public static Properties prop;
	
	public PropHandler() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/qa/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	

}
