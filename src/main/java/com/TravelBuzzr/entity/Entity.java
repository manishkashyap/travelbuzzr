package com.TravelBuzzr.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Entity<T> {
	public <T> T fromJSON(String json) 
            throws JsonProcessingException, IOException;
	public String toJSON() throws JsonProcessingException, IOException;
}
