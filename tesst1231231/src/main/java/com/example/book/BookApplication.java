package com.example.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("com.example.book.entity")
//@EnableJpaRepositories(entityManagerFactoryRef = "dialerEntityManagerFactory", basePackages = {"com.example.book.entity"})
public class BookApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

}
