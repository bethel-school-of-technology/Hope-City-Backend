package com.codebrew.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.codebrew.models.Admin;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class AdminDataAccessService implements AdminDao {
    private static List<Admin> DB = new ArrayList<>();

    @Override
    public int insertAdmin(UUID id, Admin admin) {
        DB.add(new Admin());
        return 1;
    }

    @Override
    public <S extends Admin> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Admin> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Admin> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Admin> S insert(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Admin> List<S> insert(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Admin> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Admin> findById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(UUID id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Admin> findAllById(Iterable<UUID> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(UUID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Admin entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends Admin> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public <S extends Admin> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Admin> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Admin> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    // @Override
    // public int insertAdmin(UUID id, Admin admin) {

    // return 0;
    // }

}