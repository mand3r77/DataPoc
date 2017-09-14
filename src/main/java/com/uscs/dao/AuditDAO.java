package com.uscs.dao;

import java.util.List;

import com.uscs.model.AuditInfoVO;
import com.uscs.model.ReturnAuditVO;

public interface AuditDAO {

	
	public void writeAuditInfo (AuditInfoVO auditInfoVO);
	
	public List<ReturnAuditVO> readAuditInfo();
}
