package com.jpa.test;


import com.jpa.test.dao.StudentRepository;
import com.jpa.test.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootstudentexmpApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext Context=	SpringApplication.run(SpringbootstudentexmpApplication.class, args);
	}


}
