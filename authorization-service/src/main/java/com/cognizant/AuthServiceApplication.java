package com.cognizant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.model.MyUser;
import com.cognizant.repository.UserRepo;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class AuthServiceApplication implements CommandLineRunner{
	private final UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.save(new MyUser(1, "admin1", "password1"));
		userRepo.save(new MyUser(2, "admin2", "password2"));
		userRepo.save(new MyUser(3, "admin3", "password3"));
		userRepo.save(new MyUser(4, "admin4", "password4"));

	}

}


