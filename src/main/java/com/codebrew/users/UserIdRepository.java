package com.codebrew.users;


import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.security.core.userdetails.User;
import com.codebrew.users.Users;

public interface UserIdRepository extends JpaRepository<Users, String> {

    Users findById(Long id);

}
