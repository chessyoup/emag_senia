package com.flow.emag.api.config;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Environment {
	
	private static final Logger LOG = Logger.getLogger(Environment.class
			.getName());
	
	private static Properties config = new Properties();

	static {

		try {
			config.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (IOException e) {
			try {
				config.load(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("resources/config.properties"));
			} catch (IOException e1) {
				LOG.log(Level.SEVERE,"Error on reading environment properties!",e1);				
			}
		}
	}
	
	public static String getProperty(String key,String defaultValue){
		return config.getProperty(key, defaultValue);
	}
	
	public static String getProperty(String key){
		return config.getProperty(key);
	}	
}
