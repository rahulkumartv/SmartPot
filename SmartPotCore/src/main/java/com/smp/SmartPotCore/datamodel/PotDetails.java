package com.smp.SmartPotCore.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pot")
public class PotDetails {
	public PotDetails()
	{
		
	}
	@Id
	@Column(name="pot_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pot_id;
	@Column(name="user_id")
	private int user_id;
	@Column(name="zipCode")
	private String zipCode;
	@Column(name="location")
	private String location;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPotid() {
		return pot_id;
	}
	public void setPotid(int pot_id) {
		this.pot_id = pot_id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	
	
	@Override
	public String toString() {
	  return  "potDetails [potid=" + pot_id + ", location=" + location
				+ ", zipCode=" + zipCode + "]\n";
	}	
}
