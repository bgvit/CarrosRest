package br.com.bernardo.carrosrest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CarrosRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrosRestApplication.class, args);
	}

}
