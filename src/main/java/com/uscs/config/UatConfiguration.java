package com.uscs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration
//@PropertySource(value = { "classpath:uatJdbc.properties" })
@PropertySource(value = "file:/c:/EWM_/DataPoc/prop/testPoc.properties", ignoreResourceNotFound = true)
public class UatConfiguration {

	private static final String CONNECT_TEST_QUERY = "SELECT 1 FROM SYSIBM.SYSDUMMY1";
	
	private @Value("${jdbc.uatdb2.driverClassName}") String uatdb2DriverClassName;
	private @Value("${jdbc.uatdb2.db.url}") String uatdb2JdbcUrl;
	private @Value("${jdbc.uatdb2.db.user}") String uatdb2Username;
	private @Value("${jdbc.uatdb2.db.pwd}") String uatdb2Password;
	
	@Bean
	public DataSource uatdb2() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(uatdb2DriverClassName);
		config.setJdbcUrl(uatdb2JdbcUrl);
		config.setUsername(uatdb2Username);
		config.setPassword(uatdb2Password);
		config.setConnectionTestQuery(CONNECT_TEST_QUERY);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}
}
