package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Admin;

public class AdminDataAccessService implements AdminDao {
    private static List<Admin> DB = new ArrayList<>();

    @Override
    public int insertAdmin(id, Admin admin) {
        DB.add(new Admin());
        return 1;
    }

    @Override
    public int insertAdmin(UUID id, Admin admin) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}