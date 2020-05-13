package dao;

import java.util.UUID;

import models.Admin;


    int insertAdmin(UUID id, Admin admin);

    default int addAdmin(Admin admin) {
        UUID id = UUID.randomUUID();
        return insertAdmin(id, admin);
    }
}