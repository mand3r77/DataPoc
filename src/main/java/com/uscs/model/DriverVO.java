package com.uscs.model;

import org.springframework.stereotype.Component;





@Component
public class DriverVO {

	public String driverNumber;
	public String driverID;
	public String  firstName;
	public String  lastName;
	public String  contactNumber;
	public String birthDate;
	public String issueFlag;
	public String createTS;
	public String createUsr;
	public String updateTS;
	public String updateUsr;
	public String getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}
	public String getDriverID() {
		return driverID;
	}
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getIssueFlag() {
		return issueFlag;
	}
	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag;
	}
	public String getCreateTS() {
		return createTS;
	}
	public void setCreateTS(String createTS) {
		this.createTS = createTS;
	}
	public String getCreateUsr() {
		return createUsr;
	}
	public void setCreateUsr(String createUsr) {
		this.createUsr = createUsr;
	}
	public String getUpdateTS() {
		return updateTS;
	}
	public void setUpdateTS(String updateTS) {
		this.updateTS = updateTS;
	}
	public String getUpdateUsr() {
		return updateUsr;
	}
	public void setUpdateUsr(String updateUsr) {
		this.updateUsr = updateUsr;
	}

	
}
