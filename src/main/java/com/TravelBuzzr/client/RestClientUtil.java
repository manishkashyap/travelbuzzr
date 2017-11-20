package com.TravelBuzzr.client;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.TravelBuzzr.entity.User;

public class RestClientUtil {
    public void getUserByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/api/users/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User.class, 1);
        User user = responseEntity.getBody();
        System.out.println("Id:"+user.getId()+", Phone :"+user.getPhone());      
    }
    
    public void getAllUsersDemo() {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/api/users";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<User[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);
        User[] users = responseEntity.getBody();
        for(User user : users) {
              System.out.println("Id:"+user.getId()+", Title:"+user.getPhone());
        }
    }
    public void addUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/api/users";
	User objUser = new User();
	objUser.setPhone("Spring REST Security using Hibernate");
        HttpEntity<User> requestEntity = new HttpEntity<User>(objUser, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
    	util.getAllUsersDemo();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    }    
} 
