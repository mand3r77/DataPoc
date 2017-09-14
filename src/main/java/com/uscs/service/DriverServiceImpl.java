package com.uscs.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uscs.common.config.utils.compare.ObjectCompare;
import com.uscs.dao.DiffObject;
import com.uscs.dao.DriverDAO;
import com.uscs.model.AuditInfoVO;
import com.uscs.model.DriverVO;

@Service
public class DriverServiceImpl implements DriverService {

	@Inject
	DriverDAO driverDAO;
	
	public DriverVO getDriver() {
		
		return driverDAO.getDriver();
	}
	
	
	public AuditInfoVO compareObject (Object obj1, Object obj2){
		
		ObjectCompare compare = new ObjectCompare();
		@SuppressWarnings("rawtypes")
		Map<String, DiffObject> test = compare.compareObjects(obj1, obj2);
		ObjectMapper objectMapper = new ObjectMapper();
		@SuppressWarnings("unused")
		String jsonData = null;
		try {
			jsonData = objectMapper.writeValueAsString(test);
		} catch (JsonProcessingException e) {
			   e.printStackTrace();
		}
		
		AuditInfoVO auditInfo = new AuditInfoVO();
		auditInfo.setJsonData(jsonData);
		auditInfo.setCreateUser("hqmmande");
		
		return auditInfo;
		
	}

}
