package com.codebrew.dao;

import com.codebrew.models.Events;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Events, Long> {
    Events findByEventId(Integer id);

	
}