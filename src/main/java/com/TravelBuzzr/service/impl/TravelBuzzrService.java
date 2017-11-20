package com.TravelBuzzr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelBuzzr.dao.ITravelBuzzrDao;
import com.TravelBuzzr.entity.User;
import com.TravelBuzzr.service.ITravelBuzzrService;

@Service
public class TravelBuzzrService implements ITravelBuzzrService {
	
	@Autowired
	private ITravelBuzzrDao travelBuzzrDao;

	@Override
	public List<User> getUsers() {		
		return travelBuzzrDao.getUsers();
	}

	@Override
	public User getUserById(Integer userId) {
		return travelBuzzrDao.getUserById(userId);
	}

	@Override
	public synchronized boolean addUser(User user){
        travelBuzzrDao.addUser(user);
        return true;
	}

	@Override
	public void updateUser(User user) {
		travelBuzzrDao.updateUser(user);
		
	} 

}
