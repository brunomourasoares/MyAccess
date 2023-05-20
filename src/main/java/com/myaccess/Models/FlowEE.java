package com.myaccess.Models;

import java.sql.Timestamp;

public class FlowEE {
	
	private Long id;
	private String ssn;
	private String vehicleModel;
	private String vehiclePlate;
	private String destination;
	private String person;
	private Timestamp date;
	private String type;
	
	public FlowEE(Long id, String ssn, String vehicleModel, String vehiclePlate, String destination, String person, Timestamp date,	String type) {
		this.id = id;
		this.ssn = ssn;
		this.vehicleModel = vehicleModel;
		this.vehiclePlate = vehiclePlate;
		this.destination = destination;
		this.person = person;
		this.date = date;
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getVehicleModel() {
		return vehicleModel;
	}
	
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	
	public String getVehiclePlate() {
		return vehiclePlate;
	}
	
	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPerson() {
		return person;
	}
	
	public void setPerson(String person) {
		this.person = person;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
