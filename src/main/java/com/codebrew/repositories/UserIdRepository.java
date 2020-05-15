package com.codebrew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserIdRepository extends JpaRepository<User, String> {

    User findById(Long id);

}
