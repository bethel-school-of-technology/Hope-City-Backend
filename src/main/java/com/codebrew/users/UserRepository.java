package com.codebrew.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	List<User> findAll();

}
