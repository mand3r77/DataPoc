package com.uscs.model;

import java.sql.Timestamp;
import java.util.Date;

public class AppointmentVO {
	
	public Long apptSysId;
	public Long apptNumber;
	char apptFlag;
	Timestamp apptTS;
	public Long whseSysId;
	public Long recNum;
	public Long dtNum;
	public Long trailerSysId;
	public Long doorSysid;
	public String trailerNumber;
	public Date createTs;
	public Date updateTs;
	public String createUser;
	public String updateUser;
	public boolean saveError;
	public Long getApptSysId() {
		return apptSysId;
	}
	public void setApptSysId(Long apptSysId) {
		this.apptSysId = apptSysId;
	}
	public Long getApptNumber() {
		return apptNumber;
	}
	public void setApptNumber(Long apptNumber) {
		this.apptNumber = apptNumber;
	}
	public char getApptFlag() {
		return apptFlag;
	}
	public void setApptFlag(char apptFlag) {
		this.apptFlag = apptFlag;
	}
	public Timestamp getApptTS() {
		return apptTS;
	}
	public void setApptTS(Timestamp apptTS) {
		this.apptTS = apptTS;
	}
	public Long getWhseSysId() {
		return whseSysId;
	}
	public void setWhseSysId(Long whseSysId) {
		this.whseSysId = whseSysId;
	}
	public Long getRecNum() {
		return recNum;
	}
	public void setRecNum(Long recNum) {
		this.recNum = recNum;
	}
	public Long getDtNum() {
		return dtNum;
	}
	public void setDtNum(Long dtNum) {
		this.dtNum = dtNum;
	}
	public Date getCreateTs() {
		return createTs;
	}
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	public Date getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public boolean isSaveError() {
		return saveError;
	}
	public void setSaveError(boolean saveError) {
		this.saveError = saveError;
	}
	
	public Long getTrailerSysId() {
		return trailerSysId;
	}
	public void setTrailerSysId(Long trailerSysId) {
		this.trailerSysId = trailerSysId;
	}
	public Long getDoorSysid() {
		return doorSysid;
	}
	public void setDoorSysid(Long doorSysid) {
		this.doorSysid = doorSysid;
	}
	public String getTrailerNumber() {
		return trailerNumber;
	}
	public void setTrailerNumber(String trailerNumber) {
		this.trailerNumber = trailerNumber;
	}
	@Override
	public String toString() {
		return "AppointmentVO [apptSysId=" + apptSysId + ", apptNumber="
				+ apptNumber + ", apptFlag=" + apptFlag + ", apptTS=" + apptTS
				+ ", whseSysId=" + whseSysId + ", recNum=" + recNum
				+ ", dtNum=" + dtNum + ", trailerSysId=" + trailerSysId
				+ ", doorSysid=" + doorSysid + ", trailerNumber="
				+ trailerNumber + ", createTs=" + createTs + ", updateTs="
				+ updateTs + ", createUser=" + createUser + ", updateUser="
				+ updateUser + ", saveError=" + saveError + "]";
	}
	
}
