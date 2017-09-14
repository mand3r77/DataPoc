package com.uscs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;



import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uscs.model.DriverVO;

@Repository
public class DriverDAOImpl implements DriverDAO {
private NamedParameterJdbcTemplate namedJdbcTemplate;
		
		@Inject
		public void setDataSource(DataSource uatdb2) {
		    this.namedJdbcTemplate = new NamedParameterJdbcTemplate(uatdb2);
		}
	
	public DriverVO getDriver(){
		
		String schema = "EWMUYMDBF";
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM "+schema+".DRIVER WHERE DRIVER_FIRST_NAME = 'BRAYDEN' AND DRIVER_LAST_NAME = 'MANDER'");
		List<DriverVO> driverResult = new ArrayList<DriverVO>();
		driverResult = namedJdbcTemplate.query(query.toString(), new RowMapper<DriverVO>() {
				
				@Override
				public DriverVO mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					DriverVO driver = new DriverVO();
					driver.setDriverNumber(rs.getString("DRIVER_NUMBER")!= null ? rs.getString("DRIVER_NUMBER") : "");
					driver.setDriverID(rs.getString("DRIVER_ID") != null ? rs.getString("DRIVER_ID") : "");
					driver.setFirstName(rs.getString("DRIVER_FIRST_NAME") != null? rs.getString("DRIVER_FIRST_NAME") : "");
					driver.setLastName(rs.getString("DRIVER_LAST_NAME") != null? rs.getString("DRIVER_LAST_NAME") : "");
					driver.setContactNumber(rs.getString("DRIVER_CONTCT_NUMBER")!= null? rs.getString("DRIVER_CONTCT_NUMBER") : "");
					driver.setBirthDate(rs.getString("BIRTH_DATE")!= null? rs.getString("BIRTH_DATE") : "");
					driver.setIssueFlag(rs.getString("ISSUE_FLAG")!= null? rs.getString("ISSUE_FLAG"): " ");
					driver.setCreateTS(rs.getString("CREATE_TS")!= null? rs.getString("CREATE_TS") : "");
					driver.setCreateUsr(rs.getString("CREATE_USERID")!= null? rs.getString("CREATE_USERID") : "");
					driver.setUpdateTS(rs.getString("UPDATE_TS")!= null? rs.getString("UPDATE_TS") : "");
					driver.setUpdateUsr(rs.getString("UPDATE_USERID")!= null? rs.getString("UPDATE_USERID") : "");
					
				
					return driver;
				}
			});		
		return driverResult.get(0);
	}
}
