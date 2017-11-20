package com.TravelBuzzr;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelBuzzrApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TravelBuzzrApplication.class);
	    app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);
	    
	}
}
