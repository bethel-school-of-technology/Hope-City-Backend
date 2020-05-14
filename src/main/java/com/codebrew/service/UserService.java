package com.codebrew.service;

import java.util.List;

import com.codebrew.dao.UserDao;

import com.codebrew.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //create
    public User create(long id, String firstName, String lastName, String church, int zip, String password,
            String username) {
        return UserDao.save(new User(id, firstName, lastName, church, zip, password, username));
    }

    //retrieve
    public List<User> getAll() {
        return userDao.findAll();

    }

    //Update
    public User getByFirstName(String firstName) {
        return userDao.findByFirstName(firstName);
    }

    public User update(String firstName, String lastName, String church, int zip, String password){
        User u = userDao.findByFirstName(firstName);
        u.setLastName(lastName);
        u.setChurch(church);
        u.setZip(zip);
        u.setPassword(password);
    }

    //delete
    public void deleteAll(String username) {
        userDao.deleteAll();
    }

    public void delete(String username) {
        User u = userDao.findByFirstName(firstName);
        userDao.delete(u);
    }

}