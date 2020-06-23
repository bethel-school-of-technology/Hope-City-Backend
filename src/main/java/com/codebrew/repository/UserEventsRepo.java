package com.codebrew.repository;

import java.util.List;

import com.codebrew.models.Attendees;
//import com.codebrew.models.Events;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventsRepo extends JpaRepository<Attendees, Long> {
 static Attendees findAttendeesById(){
	 return null;
 };

	static List<Attendees> findAllAttending() {
		return null;
	}
	// static Events saveAll(Object attendees) {
	// 	return null;
	// }
    
}