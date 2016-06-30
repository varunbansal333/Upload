package com.fileUploader.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfiguration {

	public void loadProperties(Properties prop){
		String configProperty="databaseConfig.properties";
		InputStream instrm = getClass().getClassLoader().getResourceAsStream(configProperty);
		try {
			prop.load(instrm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
