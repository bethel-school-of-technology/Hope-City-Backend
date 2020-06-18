package com.codebrew.repository;

import com.codebrew.models.Attendees;
//import com.codebrew.models.Events;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventsRepo extends JpaRepository<Attendees, Long> {
	
	Attendees saveAll(Attendees attendees);
	Attendees findAll(Long id);
}