package com.uscs.service;

import java.util.List;

import com.uscs.model.AuditInfoVO;
import com.uscs.model.ReturnAuditVO;

public interface AuditService {

	
	public void writeAuditInfo (AuditInfoVO auditInfoVO);
	
	public List<ReturnAuditVO> readAuditInfo();
}
