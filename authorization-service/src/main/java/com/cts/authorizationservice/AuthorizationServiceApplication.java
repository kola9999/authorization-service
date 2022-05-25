package com.cts.authorizationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cts.authorizationservice.entity.User;
import com.cts.authorizationservice.repository.UserRepository;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AuthorizationServiceApplication implements CommandLineRunner {

	
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		repository.save(new User(1, "user", bCryptPasswordEncoder.encode("user")));
	}

}
