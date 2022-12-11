package com.dev.delta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.delta.dto.UserDTO;

@SpringBootApplication
public class SpringbootTravelForestCodecanyonApplication implements CommandLineRunner {

	@Autowired
	UserDTO userDTO;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTravelForestCodecanyonApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		userDTO.populate();
		
	}

}
