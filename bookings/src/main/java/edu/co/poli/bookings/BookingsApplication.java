package edu.co.poli.bookings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BookingsApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookingsApplication.class, args);
	}

}
