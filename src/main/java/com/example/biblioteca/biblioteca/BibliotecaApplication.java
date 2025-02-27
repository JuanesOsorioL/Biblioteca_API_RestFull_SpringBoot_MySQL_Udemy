package com.example.biblioteca.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
/*
spring.application.name=biblioteca



spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

Cambiar por:

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect*/
