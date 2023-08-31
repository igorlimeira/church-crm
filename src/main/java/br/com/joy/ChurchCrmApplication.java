package br.com.joy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChurchCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchCrmApplication.class, args);
	}

}
