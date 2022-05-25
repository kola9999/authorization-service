package com.cognizant.model;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Model class ->user credentials
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {

	private String userName;

	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Password should contain alpha numeric values")
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
