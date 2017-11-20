package com.TravelBuzzr.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
	public static Logger getLogger() {
		Throwable t = new Throwable();
		StackTraceElement directCaller = t.getStackTrace()[1];
		return LogManager.getLogger(directCaller.getClassName());
	}
}
