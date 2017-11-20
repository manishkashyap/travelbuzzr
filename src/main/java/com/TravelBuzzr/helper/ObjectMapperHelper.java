package com.TravelBuzzr.helper;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.*;

public class ObjectMapperHelper {

	protected static Logger logger = LoggerHelper.getLogger();

	private static ObjectMapper objectMapper = null;

	static {
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}

	public static String objectToJson(Object value) {
		String result = null;
		try {
			result = objectMapper.writeValueAsString(value);
		} catch(JsonProcessingException e) {
			logger.error(e);
		}
		return result;
	}

	public static <T extends Object>  T jsonToObject(String value, Class<T> classz) {
		T result = null;
		try {
			result = objectMapper.readValue(value, classz);
		} catch(JsonProcessingException e) {
			logger.warn(e);
			//throw new WebKlipException("Parsing Error : "+e.getMessage());
		} catch(IOException e) {
			logger.warn(e);
			//throw new WebKlipException("Parsing Error : "+e.getMessage());
		}
		return result;
	}
}
