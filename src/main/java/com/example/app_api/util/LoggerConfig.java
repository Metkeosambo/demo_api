package com.example.app_api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerConfig {
	public static void setError(String controller,String Msg) {
		Logger logger = LoggerFactory.getLogger(controller);
		logger.error(Msg);
	}
	public static void setInfo(String controller,String Msg) {
		Logger logger = LoggerFactory.getLogger(controller);
		logger.info(Msg);
	}
	
}
