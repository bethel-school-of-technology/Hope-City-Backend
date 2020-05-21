package com.codebrew.dao;

import com.codebrew.models.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByEventId(Long id);

	
}