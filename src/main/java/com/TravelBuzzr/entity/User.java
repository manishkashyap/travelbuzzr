package com.TravelBuzzr.entity;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.TravelBuzzr.helper.ObjectMapperHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name="user")
public class User implements com.TravelBuzzr.entity.Entity<User> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
        private int id;  
	@Column(name="phone")
        private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	public User fromJSON(String json) 
            throws JsonProcessingException, IOException {
		return (User)ObjectMapperHelper.jsonToObject(json, this.getClass());
	}
	
	public String toJSON() 
            throws JsonProcessingException, IOException {
		return ObjectMapperHelper.objectToJson(this);
	}
}
