package com.TravelBuzzr.service;

import java.util.List;

import com.TravelBuzzr.entity.User;

public interface ITravelBuzzrService {
	
	List<User> getUsers();
	User getUserById(Integer userId);
	boolean addUser(User user);
	void updateUser(User user);
}
