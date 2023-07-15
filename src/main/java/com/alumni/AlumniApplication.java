package com.alumni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

@SpringBootApplication
public class AlumniApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
        String seed="w7A&e5LpUs8FxEv2FaBR";
        return new BCryptPasswordEncoder(10, new SecureRandom(seed.getBytes(StandardCharsets.UTF_8)));
//		return new BCryptPasswordEncoder();
	}


	public static void main(String[] args) {
		SpringApplication.run(AlumniApplication.class, args);
	}

}
