package com.uscs.dao;

import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uscs.model.AuditInfoVO;
import com.uscs.model.ReturnAuditVO;

@Repository
public class AuditDAOImpl implements AuditDAO {
	
	String schema = "EWMUYMDBF";
	private final String INSERT_STATEMENT = "INSERT INTO "+schema+".DPOC_AUDIT (JSON_DATA,CREATE_USER,CREATED_TS)VALUES (:jsonData,:createUser,CURRENT TIMESTAMP)";
	private final String READ_STATEMENT ="SELECT AUDIT_SYSID,JSON_DATA,CREATE_USER,CREATED_TS FROM "+schema+".DPOC_AUDIT";
	
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Inject
	public void setDataSource(DataSource uatdb2) {
	    this.namedJdbcTemplate = new NamedParameterJdbcTemplate(uatdb2);
	}
	
	
public void writeAuditInfo (AuditInfoVO auditInfoVO){
	
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("jsonData",auditInfoVO.getJsonData());
	params.put("createUser", auditInfoVO.getCreateUser());
	
	try {
		namedJdbcTemplate.update(INSERT_STATEMENT, params);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	

public List<ReturnAuditVO> readAuditInfo(){
	
	List<ReturnAuditVO> auditInfo = new ArrayList<ReturnAuditVO>();
	
	
	auditInfo = namedJdbcTemplate.query(READ_STATEMENT, new RowMapper<ReturnAuditVO>() {

		
		@SuppressWarnings("unchecked")
		@Override
		public ReturnAuditVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
			ReturnAuditVO readAuditInfo = new ReturnAuditVO();
		
			  readAuditInfo.setAuditSysID(rs.getString("AUDIT_SYSID")!= null ? Long.toString(rs.getLong("AUDIT_SYSID")):"");
		

				  Map<String, DiffObject> jsonEntity= new HashMap<String, DiffObject>();
				  ObjectMapper objectMapper=new ObjectMapper();
				  InputStream inputStream=((Clob)rs.getObject("JSON_DATA")).getAsciiStream();
				  StringWriter stringWritter = new StringWriter();
				  
				try {
					IOUtils.copy(inputStream, stringWritter); 
				    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				    jsonEntity = objectMapper.readValue(stringWritter.toString(), HashMap.class);
				  
				} catch (Exception e) {
					e.printStackTrace();
				}
	
			  readAuditInfo.setJsonData(jsonEntity);
			  readAuditInfo.setCreateUser(rs.getString("CREATE_USER"));
			  readAuditInfo.setCreatedTS(rs.getString("CREATED_TS"));	
			  
			  return readAuditInfo; 
			}	 
		});  
		return auditInfo;	
	  }
	}
	
