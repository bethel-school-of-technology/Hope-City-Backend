package com.codebrew.dao;

import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface UserDao extends MongoRepository<User, Long> {
    public User findByFirstName(String firstName);

    public List<User> findByUsername(String userName);

}
