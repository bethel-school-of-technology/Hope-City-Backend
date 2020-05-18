package com.codebrew.users;

import java.util.List;

import javax.validation.Valid;

import com.codebrew.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User, Long> {
	Object save = null;

	User findByUsername(String username);

	List<Admin> findAll();

	static Admin save(@Valid Admin admin) {
		return null;
	}
=======
public interface UserRepository extends JpaRepository<Users, String> {
	User findByUsername(String username);

	List<Users> findAll();


>>>>>>> 7c46689b03ede19c7efc711b20adfbbfcc85875c

}
