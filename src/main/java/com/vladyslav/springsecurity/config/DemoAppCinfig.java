package com.vladyslav.springsecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.vladyslav.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppCinfig {
	
	// set up variable to hold the properties
	
	@Autowired
	private Environment env;
	
	//set up a logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	//define a bean for viewResolver
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
	
		return viewResolver;
	}
	
	// define a bean for security datasourse
	
	@Bean
	public DataSource securityDataSourse() {
		// create connection pool
		ComboPooledDataSource securityDataSourse =
					                  new ComboPooledDataSource();		
		
		try {
			securityDataSourse.setDriverClass(env.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException e) {
			 throw new RuntimeException(e);
		}
		
		// log the connection props
					logger.info(" >>>> jdbc.url=" + env.getProperty("jdbc.url"));
					logger.info(" >>>> jdbc.user=" + env.getProperty("jdbc.user"));
					
					// set databases connections props
					securityDataSourse.setJdbcUrl(env.getProperty("jdbc.url"));
					securityDataSourse.setUser(env.getProperty("jdbc.user"));
					securityDataSourse.setPassword(env.getProperty("jdbc.password"));
					
					
					// set connection pool props
					
					securityDataSourse.setInitialPoolSize(
							getIntProperty("connection.pool.initialPoolSize"));
					securityDataSourse.setMinPoolSize(
							getIntProperty("connection.pool.minPoolSize"));
					securityDataSourse.setMaxPoolSize(
							getIntProperty("connection.pool.maxPoolSize"));
					securityDataSourse.setMaxIdleTime(
							getIntProperty("connection.pool.maxIdleTime"));
		                       
		return securityDataSourse;
	}
	
	// need a helper method
	// read environment property and convert to int
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

}
