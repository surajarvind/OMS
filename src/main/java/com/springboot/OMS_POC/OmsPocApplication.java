package com.springboot.OMS_POC;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Order Management Services Project",description = "Order Microservices"))
@EnableCaching

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
