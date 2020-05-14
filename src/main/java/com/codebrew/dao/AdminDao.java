package com.codebrew.dao;

import java.util.UUID;

import com.codebrew.models.Admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories(basePackageClasses = AdminDao.class)
@Repository
public interface AdminDao extends MongoRepository<Admin, UUID>{

    int insertAdmin(UUID id, Admin admin);

    default int addAdmin(Admin admin) {
        UUID id = UUID.randomUUID();
        return insertAdmin(id, admin);
    }
}