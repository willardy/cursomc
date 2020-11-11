package com.willardy.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.willardy.cursomc.services.DBService;

@Configurable
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService DBService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		DBService.instantiateTestDatabase();
		return true;
	}
}
