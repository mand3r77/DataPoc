package com.uscs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uscs.dao.AuditDAO;
import com.uscs.model.AuditInfoVO;
import com.uscs.model.ReturnAuditVO;


@Service
public class AuditServiceImpl implements AuditService {
	
	@Inject
	AuditDAO auditDAO;
	
	
	public void writeAuditInfo (AuditInfoVO auditInfoVO){
		auditDAO.writeAuditInfo(auditInfoVO);
	}

	
	public List<ReturnAuditVO> readAuditInfo(){
		List<ReturnAuditVO> auditList = auditDAO.readAuditInfo();
		return auditList;
	}
}
