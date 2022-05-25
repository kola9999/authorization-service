package com.cts.authorizationservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.authorizationservice.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByUserName(String userName);
}
