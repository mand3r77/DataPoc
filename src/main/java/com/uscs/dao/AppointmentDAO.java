package com.uscs.dao;

import java.util.List;

import com.uscs.model.AppointmentVO;

public interface AppointmentDAO {

	public long getMockAppointmentNumber();
	
	public boolean createAppointmentHeader(long apptNumebr,char apptFlag);
	
	public boolean createInboundAppointment(List<AppointmentVO> apptList);
	
	public boolean createOutboundAppointment(List<AppointmentVO> apptList);
	
	public Long getLastAppointment(List<AppointmentVO> apptList);

	public Long getLastAppointmentByAppt(AppointmentVO appt);
}
