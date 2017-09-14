package com.uscs.model;

import java.util.Map;

import com.uscs.dao.DiffObject;

public class ReturnAuditVO {

public String auditSysID;
	
	public Map<String,DiffObject> jsonData;
	
	public String createUser;
	
	public String createdTS;

	public String getAuditSysID() {
		return auditSysID;
	}

	public void setAuditSysID(String auditSysID) {
		this.auditSysID = auditSysID;
	}

	public Map<String, DiffObject> getJsonData() {
		return jsonData;
	}

	public void setJsonData(Map<String, DiffObject> jsonData) {
		this.jsonData = jsonData;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(String createdTS) {
		this.createdTS = createdTS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((auditSysID == null) ? 0 : auditSysID.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((createdTS == null) ? 0 : createdTS.hashCode());
		result = prime * result
				+ ((jsonData == null) ? 0 : jsonData.hashCode());
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
		ReturnAuditVO other = (ReturnAuditVO) obj;
		if (auditSysID == null) {
			if (other.auditSysID != null)
				return false;
		} else if (!auditSysID.equals(other.auditSysID))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createdTS == null) {
			if (other.createdTS != null)
				return false;
		} else if (!createdTS.equals(other.createdTS))
			return false;
		if (jsonData == null) {
			if (other.jsonData != null)
				return false;
		} else if (!jsonData.equals(other.jsonData))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReturnAuditVO [auditSysID=" + auditSysID + ", jsonData="
				+ jsonData + ", createUser=" + createUser + ", createdTS="
				+ createdTS + "]";
	}
	
	
	
}
