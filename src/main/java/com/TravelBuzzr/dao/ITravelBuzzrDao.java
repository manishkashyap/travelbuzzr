package com.TravelBuzzr.dao;

import java.util.List;

import com.TravelBuzzr.entity.Pnr;
import com.TravelBuzzr.entity.User;
import com.TravelBuzzr.entity.UserPnr;

public interface ITravelBuzzrDao {
	List<User> getUsers();
	User getUserById(Integer userId);
	void addUser(User user);
	void updateUser(User user);
	
	List<Pnr> getPnrs();
	Pnr getPnrById(Integer pnrId);
	Pnr getPnrByNumber(String pnrNumber);
	void addPnr(Pnr pnr);
	
	UserPnr addUserPnr(UserPnr userPnr);
	List<UserPnr> getUserPnrsByUserId(Integer userId);
	List<UserPnr> getUserPnrsByPnrId(Integer pnrId);
}
