package com.example.clinicaOdontologica;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		//PropertyConfigurator.configure("log4j.properties"); no es necesario, log4j busca automaticamente el archivo
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
	}


}
