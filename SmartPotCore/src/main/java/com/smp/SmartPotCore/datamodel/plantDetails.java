package com.smp.SmartPotCore.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plant")
public class plantDetails {
	public plantDetails()
	{
		
	}
	@Id
	@Column(name="plant_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int plant_id;
	@Column(name="plant_name")
	private String plant_name;
	@Column(name="summary")
	private String summary;
	
	public int getPlantId() {
		return plant_id;
	}
	public void setPlantId(int plant_id) {
		this.plant_id = plant_id;
	}
	public String getPlant_name() {
		return plant_name;
	}
	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
	  return  "Plant Details [plantid=" + plant_id + ", plant name=" + plant_name
				+ ", summary=" + summary + "]\n";
	}
}
