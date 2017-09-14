package com.uscs.service;

import java.util.List;

import com.uscs.model.AppointmentVO;

public interface AppointmentService {

	public boolean createAppointmentHeader(long mockApptNumber,char ApptFlag);
	
	public List<AppointmentVO> createInboundAppointment(List<AppointmentVO> apptList);
	
	public List<AppointmentVO> createOutboundAppointment(List<AppointmentVO> apptList);
	
	public long getAppointment(AppointmentVO appt);
	
	public long getMockAppointmentNumber();
	
	
}
