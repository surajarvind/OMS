package com.springboot.OMS_POC;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OmsPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsPocApplication.class, args);
	}



	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
