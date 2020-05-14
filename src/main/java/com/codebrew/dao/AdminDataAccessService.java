package com.codebrew.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.codebrew.models.Admin;

public class AdminDataAccessService implements AdminDao {
    private static List<Admin> DB = new ArrayList<>();

    @Override
    public int insertAdmin(UUID id, Admin admin) {
        DB.add(new Admin());
        return 1;
    }

    // @Override
    // public int insertAdmin(UUID id, Admin admin) {

    // return 0;
    // }

}