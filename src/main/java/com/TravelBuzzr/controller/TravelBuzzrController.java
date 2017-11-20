package com.TravelBuzzr.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.TravelBuzzr.entity.User;
import com.TravelBuzzr.service.ITravelBuzzrMessagesService;
import com.TravelBuzzr.service.ITravelBuzzrService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("api")
public class TravelBuzzrController {
	@Autowired
	private ITravelBuzzrService trravelBuzzrService;
	
	@Autowired
	private ITravelBuzzrMessagesService trravelBuzzrMessagesService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = trravelBuzzrService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = trravelBuzzrService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) throws JsonProcessingException, IOException {
                trravelBuzzrMessagesService.writeMessage(user.toJSON());
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}