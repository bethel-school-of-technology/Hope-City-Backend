package com.codebrew.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codebrew.models.Attending;

public interface AttendingDao extends JpaRepository<Attending, Long> {
	
	
}
