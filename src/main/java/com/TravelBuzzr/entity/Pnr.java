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
@Table(name="pnr")
public class Pnr implements com.TravelBuzzr.entity.Entity<Pnr> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
        private int id;  
	@Column(name="pnr_number")
        private String pnrNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pnrNumber == null) ? 0 : pnrNumber.hashCode());
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
		Pnr other = (Pnr) obj;
		if (pnrNumber == null) {
			if (other.pnrNumber != null)
				return false;
		} else if (!pnrNumber.equals(other.pnrNumber))
			return false;
		return true;
	}
	
	public Pnr fromJSON(String json) 
            throws JsonProcessingException, IOException {
		return (Pnr)ObjectMapperHelper.jsonToObject(json, this.getClass());
	}
	
	public String toJSON() 
            throws JsonProcessingException, IOException {
		return ObjectMapperHelper.objectToJson(this);
	}
	
	
}
