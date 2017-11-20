package com.TravelBuzzr.service;

import java.io.IOException;

import javax.jms.JMSException;

public interface ITravelBuzzrMessagesService {
	
	void readMessage(String message) throws JMSException;
	void writeMessage(String message) throws IOException;
}
