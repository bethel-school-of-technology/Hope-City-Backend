package com.codebrew.repository;

import com.codebrew.models.Attendees;
import com.codebrew.models.Events;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventsRepo extends JpaRepository<Attendees, Long> {

	static Attendees saveAll(Attendees attendees) {
		return null;
	}

	static Attendees findAll(Long id) {
		return null;
	}

	// default Attendees save(Attendees attendees) {
	// 	return null;
	// }
    
}