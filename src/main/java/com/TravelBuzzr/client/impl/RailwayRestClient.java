package com.TravelBuzzr.client.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.TravelBuzzr.client.IRailwayRestClient;

@Service
public class RailwayRestClient implements IRailwayRestClient{
	private static final Logger logger = LoggerFactory.getLogger(RailwayRestClient.class);
	private final RestTemplate restTemplate;
	
	public RailwayRestClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	@Override
	public Map<?, ?> getLiveTrainStatus(String trainNumber, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<?, ?> getPnrStatus(String pnrNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Response {"train": {"number": "12990", "classes": [{"code": "3A", "available": "Y", "class-code": "3A"}, {"code": "CC", "available": "N", "class-code": "CC"}, {"code": "2S", "available": "N", "class-code": "2S"}, {"code": "1A", "available": "N", "class-code": "1A"}, {"code": "2A", "available": "Y", "class-code": "2A"}, {"code": "3E", "available": "N", "class-code": "3E"}, {"code": "SL", "available": "Y", "class-code": "SL"}, {"code": "FC", "available": "N", "class-code": "FC"}], "name": "AII DDR SF EXP", "days": [{"code": "MON", "day-code": "MON", "runs": "N"}, {"code": "TUE", "day-code": "TUE", "runs": "N"}, {"code": "WED", "day-code": "WED", "runs": "Y"}, {"code": "THU", "day-code": "THU", "runs": "N"}, {"code": "FRI", "day-code": "FRI", "runs": "Y"}, {"code": "SAT", "day-code": "SAT", "runs": "N"}, {"code": "SUN", "day-code": "SUN", "runs": "Y"}]}, "debit": 1, "route": [{"distance": 0, "lat": 26.25, "station": {"code": "AII", "lng": 74.666667, "name": "AJMER", "lat": 26.25}, "state": null, "schdep": "19:20", "day": 1, "lng": 74.666667, "fullname": "AJMER", "scharr": "SOURCE", "halt": -1, "code": "AII", "no": 1}, {"distance": 52, "lat": 26.0992137, "station": {"code": "BER", "lng": 74.3127044, "name": "BEAWAR", "lat": 26.0992137}, "state": null, "schdep": "20:06", "day": 1, "lng": 74.3127044, "fullname": "BEAWAR", "scharr": "20:04", "halt": 2, "code": "BER", "no": 2}, {"distance": 118, "lat": 25.861057, "station": {"code": "SOD", "lng": 73.7542302, "name": "SOJAT ROAD", "lat": 25.861057}, "state": null, "schdep": "20:55", "day": 1, "lng": 73.7542302, "fullname": "SOJAT ROAD", "scharr": "20:53", "halt": 2, "code": "SOD", "no": 3}, {"distance": 139, "lat": 25.7259059, "station": {"code": "MJ", "lng": 73.6097336, "name": "MARWAR JN", "lat": 25.7259059}, "state": null, "schdep": "21:38", "day": 1, "lng": 73.6097336, "fullname": "MARWAR JN", "scharr": "21:33", "halt": 5, "code": "MJ", "no": 4}, {"distance": 191, "lat": 26.4190285, "station": {"code": "RANI", "lng": 87.267956, "name": "RANI", "lat": 26.4190285}, "state": null, "schdep": "22:15", "day": 1, "lng": 87.267956, "fullname": "RANI", "scharr": "22:13", "halt": 2, "code": "RANI", "no": 5}, {"distance": 206, "lat": 25.2335457, "station": {"code": "FA", "lng": 73.2354341, "name": "FALNA", "lat": 25.2335457}, "state": null, "schdep": "22:27", "day": 1, "lng": 73.2354341, "fullname": "FALNA", "scharr": "22:25", "halt": 2, "code": "FA", "no": 6}, {"distance": 222, "lat": 25.1130774, "station": {"code": "JWB", "lng": 73.1530272, "name": "JAWAI BANDH", "lat": 25.1130774}, "state": null, "schdep": "23:01", "day": 1, "lng": 73.1530272, "fullname": "JAWAI BANDH", "scharr": "22:59", "halt": 2, "code": "JWB", "no": 7}, {"distance": 261, "lat": 24.7911168, "station": {"code": "SOH", "lng": 73.0396336, "name": "SIROHI ROAD", "lat": 24.7911168}, "state": null, "schdep": "23:46", "day": 1, "lng": 73.0396336, "fullname": "SIROHI ROAD", "scharr": "23:44", "halt": 2, "code": "SOH", "no": 8}, {"distance": 305, "lat": 24.4828256, "station": {"code": "ABR", "lng": 72.7820384, "name": "ABU ROAD", "lat": 24.4828256}, "state": null, "schdep": "00:40", "day": 2, "lng": 72.7820384, "fullname": "ABU ROAD", "scharr": "00:30", "halt": 10, "code": "ABR", "no": 9}, {"distance": 357, "lat": 24.1709794, "station": {"code": "PNU", "lng": 72.4366375, "name": "PALANPUR JN", "lat": 24.1709794}, "state": null, "schdep": "01:55", "day": 2, "lng": 72.4366375, "fullname": "PALANPUR JN", "scharr": "01:53", "halt": 2, "code": "PNU", "no": 10}, {"distance": 374, "lat": 24.0336286, "station": {"code": "CHP", "lng": 72.4003572, "name": "CHHAPI", "lat": 24.0336286}, "state": null, "schdep": "02:09", "day": 2, "lng": 72.4003572, "fullname": "CHHAPI", "scharr": "02:07", "halt": 2, "code": "CHP", "no": 11}, {"distance": 401, "lat": 23.8064926, "station": {"code": "UJA", "lng": 72.3801425, "name": "UNJHA", "lat": 23.8064926}, "state": null, "schdep": "02:43", "day": 2, "lng": 72.3801425, "fullname": "UNJHA", "scharr": "02:41", "halt": 2, "code": "UJA", "no": 12}, {"distance": 422, "lat": 23.666667, "station": {"code": "MSH", "lng": 72.5, "name": "MAHESANA JN", "lat": 23.666667}, "state": null, "schdep": "03:05", "day": 2, "lng": 72.5, "fullname": "MAHESANA JN", "scharr": "03:03", "halt": 2, "code": "MSH", "no": 13}, {"distance": 510, "lat": 23.0216238, "station": {"code": "ADI", "lng": 72.5797068, "name": "AHMEDABAD JN", "lat": 23.0216238}, "state": null, "schdep": "04:55", "day": 2, "lng": 72.5797068, "fullname": "AHMEDABAD JN", "scharr": "04:35", "halt": 20, "code": "ADI", "no": 14}, {"distance": 555, "lat": 22.6895073, "station": {"code": "ND", "lng": 72.8715199, "name": "NADIAD JN", "lat": 22.6895073}, "state": null, "schdep": "06:01", "day": 2, "lng": 72.8715199, "fullname": "NADIAD JN", "scharr": "06:00", "halt": 1, "code": "ND", "no": 15}, {"distance": 573, "lat": 22.5584995, "station": {"code": "ANND", "lng": 72.9625629, "name": "ANAND JN", "lat": 22.5584995}, "state": null, "schdep": "06:18", "day": 2, "lng": 72.9625629, "fullname": "ANAND JN", "scharr": "06:17", "halt": 1, "code": "ANND", "no": 16}, {"distance": 609, "lat": 22.297076, "station": {"code": "BRC", "lng": 73.1957373, "name": "VADODARA JN", "lat": 22.297076}, "state": null, "schdep": "07:07", "day": 2, "lng": 73.1957373, "fullname": "VADODARA JN", "scharr": "07:02", "halt": 5, "code": "BRC", "no": 17}, {"distance": 679, "lat": 21.7080427, "station": {"code": "BH", "lng": 72.9956936, "name": "BHARUCH JN", "lat": 21.7080427}, "state": null, "schdep": "07:54", "day": 2, "lng": 72.9956936, "fullname": "BHARUCH JN", "scharr": "07:53", "halt": 1, "code": "BH", "no": 18}, {"distance": 738, "lat": 21.1864607, "station": {"code": "ST", "lng": 72.8081281, "name": "SURAT", "lat": 21.1864607}, "state": null, "schdep": "08:55", "day": 2, "lng": 72.8081281, "fullname": "SURAT", "scharr": "08:50", "halt": 5, "code": "ST", "no": 19}, {"distance": 768, "lat": 20.952407, "station": {"code": "NVS", "lng": 72.9323831, "name": "NAVSARI", "lat": 20.952407}, "state": null, "schdep": "09:18", "day": 2, "lng": 72.9323831, "fullname": "NAVSARI", "scharr": "09:16", "halt": 2, "code": "NVS", "no": 20}, {"distance": 807, "lat": 20.5, "station": {"code": "BL", "lng": 73.083333, "name": "VALSAD", "lat": 20.5}, "state": null, "schdep": "09:52", "day": 2, "lng": 73.083333, "fullname": "VALSAD", "scharr": "09:50", "halt": 2, "code": "BL", "no": 21}, {"distance": 971, "lat": 19.2287385, "station": {"code": "BVI", "lng": 72.8568773, "name": "BORIVALI", "lat": 19.2287385}, "state": null, "schdep": "11:59", "day": 2, "lng": 72.8568773, "fullname": "BORIVALI", "scharr": "11:56", "halt": 3, "code": "BVI", "no": 22}, {"distance": 995, "lat": 19.02020425, "station": {"code": "DDR", "lng": 72.8450317375941, "name": "MUMBAI(DADAR)", "lat": 19.02020425}, "state": null, "schdep": "DEST", "day": 2, "lng": 72.8450317375941, "fullname": "MUMBAI(DADAR)", "scharr": "12:40", "halt": -1, "code": "DDR", "no": 23}], "response_code": 200}
	@Override
	public Map<?, ?> getTrainRoute(String trainNumber) {
		Map<?, ?> result = restTemplate.getForObject("http://api.railwayapi.com/v2/route/train/{trainNumber}/apikey/4hk4d2hg49/", HashMap.class, trainNumber);
		return result;
	}

	@Override
	public Map<?, ?> getCancledTrains(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<?, ?> getRescheduledTrains(Date date) {
		return null;
	}
	
	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		Map<?, ?> response 
		  = restTemplate.getForObject("http://api.railwayapi.com/v2/route/train/{trainNumber}/apikey/4hk4d2hg49/", HashMap.class, "12990");
		System.out.println(response);
	}
}
