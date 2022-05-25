package com.cts.authorizationservice.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCredential {
	@NotBlank
	@Pattern(regexp = "[a-zA-Z]", message = "can contain only alphabets")
	private String userName;
	@NotBlank
	private String password;
}
