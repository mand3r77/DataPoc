package com.uscs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uscs.dao.AppointmentDAO;
import com.uscs.model.AppointmentVO;

@Service
public class AppointmentServiceImpl implements AppointmentService {


	
	@Inject
	AppointmentDAO appointmentDAO;
	
	public List<AppointmentVO> createInboundAppointment(List<AppointmentVO> apptList){
		boolean saveHadErrors = appointmentDAO.createInboundAppointment(apptList);
		
		if(!saveHadErrors){
			apptList.get(0).setApptSysId(appointmentDAO.getLastAppointment(apptList));
			return apptList;
		}
		
		apptList.get(0).setSaveError(true);
		return apptList;
	}
	
	public List<AppointmentVO> createOutboundAppointment(List<AppointmentVO> apptList){
		boolean saveHadErrors = appointmentDAO.createOutboundAppointment(apptList);
		
		if(!saveHadErrors){
			apptList.get(0).setApptSysId(appointmentDAO.getLastAppointment(apptList));
			return apptList;
		}
		
		apptList.get(0).setSaveError(true);
		return apptList;
	}
	
	
	public long getAppointment(AppointmentVO appt){
		
			return appointmentDAO.getLastAppointmentByAppt(appt);
	}

	@Override
	public boolean createAppointmentHeader(long apptNumber, char apptFlag) {
		
		return 	appointmentDAO.createAppointmentHeader(apptNumber,apptFlag);
	}

	@Override
	public long getMockAppointmentNumber() {
		
		return appointmentDAO.getMockAppointmentNumber();
	}
}
