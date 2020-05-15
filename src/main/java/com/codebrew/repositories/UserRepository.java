package com.codebrew.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, Long> {
	com.codebrew.models.User findByUsername(String username);

	List<User> findAll();

}
