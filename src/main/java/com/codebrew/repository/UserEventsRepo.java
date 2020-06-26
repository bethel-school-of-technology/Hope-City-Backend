package com.codebrew.repository;

//import java.util.List;

import com.codebrew.models.Attendees;
//import com.codebrew.models.Events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventsRepo extends JpaRepository<Attendees, Long> {
   // Attendees finAttendeesById(Long id);
	// static Events saveAll(Object attendees) {
	// 	return null;
	// }

	// static List<Attendees> findAllAttendees(){
	// 	return null;
	// }

	// static Attendees findAll(Long id) {
	// 	return null;
	// }
    
}