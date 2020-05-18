package com.codebrew.users;

import java.util.List;

import javax.validation.Valid;

import com.codebrew.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Object save = null;

	User findByUsername(String username);

	List<Admin> findAll();

	static Admin save(@Valid Admin admin) {
		return null;
	}

}
