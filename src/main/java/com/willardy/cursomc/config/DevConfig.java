package com.willardy.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.willardy.cursomc.services.DBService;

@Configurable
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService DBService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		
		DBService.instantiateTestDatabase();
		return true;
	}
}
