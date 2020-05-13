package com.codebrew.dao;

import java.util.UUID;

import com.codebrew.models.Admin;

public interface AdminDao {

    int insertAdmin(UUID id, Admin admin);

    default int addAdmin(Admin admin) {
        UUID id = UUID.randomUUID();
        return insertAdmin(id, admin);
    }
}