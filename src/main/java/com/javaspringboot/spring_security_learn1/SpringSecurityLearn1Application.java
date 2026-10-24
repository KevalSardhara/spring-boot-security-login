package com.javaspringboot.spring_security_learn1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication// (exclude = {DataSourceAutoConfiguration.class})
public class SpringSecurityLearn1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLearn1Application.class, args);
	}

}
