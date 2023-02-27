package com.dextrus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.dextrus.dao")
public class DextrusExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DextrusExplorerApplication.class, args);
	}

}
