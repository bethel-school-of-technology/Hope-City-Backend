package com.codebrew.repository;

import com.codebrew.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersIdRepository extends JpaRepository<Users, Integer> {

    Users findUserById(Integer id);

}
