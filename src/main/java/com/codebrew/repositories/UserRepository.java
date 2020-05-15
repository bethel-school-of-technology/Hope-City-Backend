package com.codebrew.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, String> {

	static User findByUsername(String username) {
	return null;
	}
}