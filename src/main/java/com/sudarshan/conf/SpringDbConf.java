package com.sudarshan.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class SpringDbConf {
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@172.16.9.93:1521:SFMS");
		dataSource.setUsername("sudarshan");
		dataSource.setPassword("sudarshan");
		
		return dataSource;
	}
	
	@Bean
	public NamedParameterJdbcTemplate getTemplate() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	
	@Bean
	public DataSourceTransactionManager getTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(getDataSource());
		
		return transactionManager;
	}
	
}
