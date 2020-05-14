package com.codebrew.controllers;

import java.util.List;

import com.codebrew.dao.UserDao;
import com.codebrew.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    // create
    @RequestMapping("/create")
    public String create(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String church, @RequestParam int zip, @RequestParam String password,
            @RequestParam String username) {
        User u = userDao.create(id, firstName, lastName, church, zip, password, username);
        return u.toString();

    }

    @RequestMapping("/get")
    public User getUser(@RequestParam String username) {
        return userService.getByFirstName(firstName);
    }

    @RequestMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/update")
    public String update(long id, String firstName, String lastName, String church, int zip, String password,
            String username) {
        User u = userService.update(id, firstName, lastName, church, zip, password, username);
        return u.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String username) {
        userService.delete(username){
            return "Deleted " + username;
        }

    @RequestMapping("/deleteall")
    public String deleteAll() {
        userService.deleteAll();
        return "Deleted all records";
    }

}