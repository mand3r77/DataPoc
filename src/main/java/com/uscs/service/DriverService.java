package com.uscs.service;

import com.uscs.model.AuditInfoVO;
import com.uscs.model.DriverVO;

public interface DriverService {

	public DriverVO getDriver();
	
	public AuditInfoVO compareObject (Object obj1, Object obj2);
}
