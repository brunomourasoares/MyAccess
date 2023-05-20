package com.myaccess.Models;

import java.sql.Timestamp;

public class Guest {

	private Long id;
    private String sSN;
    private String fullName;
    private String gender;
    private String contactNumber;
    private String companyName;
	private Timestamp createDate;
    private String observations;
	private Boolean blocked;

    public Guest(Long id, String sSN, String fullName, String gender, String contactNumber, String companyName, Timestamp createDate, String observations, Boolean blocked) {
    	this.id = id;
        this.sSN = sSN;
        this.fullName = fullName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.companyName = companyName;
        this.createDate = createDate;
        this.observations = observations;
        this.blocked = blocked;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public String getsSN() {
		return sSN;
	}

	public void setsSN(String sSN) {
		this.sSN = sSN;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
}
