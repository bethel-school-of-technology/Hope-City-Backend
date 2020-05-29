package com.codebrew.repository;

import com.codebrew.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepo extends JpaRepository<UserEvent, Long> {

    UserEvent findUserEventById(Long id);

}