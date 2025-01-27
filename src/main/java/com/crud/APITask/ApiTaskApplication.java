package com.crud.APITask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Task API", version = "2.0", description = "Task Information"))
public class ApiTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTaskApplication.class, args);
	}

}
