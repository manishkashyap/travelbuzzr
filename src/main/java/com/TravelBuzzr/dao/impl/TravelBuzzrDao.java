package com.TravelBuzzr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.TravelBuzzr.dao.ITravelBuzzrDao;
import com.TravelBuzzr.entity.Pnr;
import com.TravelBuzzr.entity.User;
import com.TravelBuzzr.entity.UserPnr;

@Transactional
@Repository
public class TravelBuzzrDao implements ITravelBuzzrDao{
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		
	}

	@Override
	public void updateUser(User user) {
		User usr = getUserById(user.getId());
		usr.setPhone(user.getPhone());
		entityManager.flush();
	}

	@Override
	public List<Pnr> getPnrs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pnr getPnrById(Integer pnrId) {
		return entityManager.find(Pnr.class, pnrId);
	}

	@Override
	public void addPnr(Pnr pnr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserPnr addUserPnr(UserPnr userPnr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPnr> getUserPnrsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPnr> getUserPnrsByPnrId(Integer pnrId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pnr getPnrByNumber(String pnrNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
