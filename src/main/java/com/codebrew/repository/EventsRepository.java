package com.codebrew.repository;

import com.codebrew.models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {
    Events findEventById(Long id);

}