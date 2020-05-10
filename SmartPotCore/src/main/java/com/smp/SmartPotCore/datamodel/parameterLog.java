package com.smp.SmartPotCore.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="parameter")
public class parameterLog {
	public parameterLog()
	{
		
	}
	
	@Id
	@Column(name="parameter_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int parameter_id;
	@Column(name="name")
	private String name;
	@Column(name="value")
	private String value;
	@Column(name="logged_at",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logged_at;
	public int getParameter_id() {
		return parameter_id;
	}

	public void setParameter_id(int parameter_id) {
		this.parameter_id = parameter_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getLogged_at() {
		return logged_at;
	}

	public void setLogged_at(Date logged_at) {
		this.logged_at = logged_at;
	}
	@Override
	public String toString() {
	  return  "Parameter Log [param_id=" + parameter_id + ",  name=" + name
				+ ", value=" + value + "]\n";
	}
}
