package com.TravelBuzzr.client;

import java.util.Date;
import java.util.Map;

public interface IRailwayRestClient {
	
	Map<?, ?> getLiveTrainStatus(String trainNumber, Date date);
	
	Map<?, ?> getPnrStatus(String pnrNumber);
	
	Map<?, ?> getTrainRoute(String trainNumber);
	
	Map<?, ?> getCancledTrains(Date date);
	
	Map<?, ?> getRescheduledTrains(Date date);
}
