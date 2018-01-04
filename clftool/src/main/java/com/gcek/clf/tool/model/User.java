package com.gcek.clf.tool.model;

import java.util.Date;

public class User {

	private int usridl;
	private String emailid;
	private String firstName;
	private String lastName;
	private String password;
	private Date createdOn;
	private String modifiedBy;
	private Date modifiedOn;
	private String role;

	public User() {

	}

	public User(String emailid, String firstName, String lastName, String password, String role) {
		super();
		this.emailid = emailid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUsridl() {
		return usridl;
	}

	public void setUsridl(int usridl) {
		this.usridl = usridl;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [usridl=" + usridl + ", emailid=" + emailid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", role=" + role + "]";
	}

	
	
	
}
