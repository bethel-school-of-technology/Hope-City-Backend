package com.codebrew.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface EventDao extends JpaRepository<User, Long> {
	
}

