package com.TravelBuzzr.service.impl;

import java.io.IOException;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.TravelBuzzr.service.ITravelBuzzrMessagesService;

@Service
public class TravelBuzzrMessagesService implements ITravelBuzzrMessagesService {
	private Logger logger = LoggerFactory.getLogger(TravelBuzzrMessagesService.class);
	
	@Autowired
    protected JmsTemplate defaultJmsTemplate;
	
	@Autowired
	protected TravelBuzzrService travelBuzzrService;  
	
	@Override
	@JmsListener(destination = "pnr_requests")
	public void readMessage(String message) throws JMSException {
		logger.info("Message recieved : " + message);
	}

	@Override
	public void writeMessage(String message) throws IOException {
		defaultJmsTemplate.convertAndSend("pnr_requests", message);
	}

}
