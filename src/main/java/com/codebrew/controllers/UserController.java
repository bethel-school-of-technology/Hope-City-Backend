package com.codebrew.controllers;

import java.util.List;

import com.codebrew.dao.UserRepository;
import com.codebrew.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableMongoRepositories
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userDao;

    // create
    @RequestMapping("/create")
    public String create(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String church, @RequestParam int zip, @RequestParam String password,
            @RequestParam String username) {
        User u = userDao.create();
        return u.toString();

    }

    // GET ONE
    @RequestMapping("/get")
    public User getUser(@RequestParam String firstName) {
        return userService.getByFirstName(firstName);
    }

    // GET ALL
    @RequestMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    // UPDATE
    @RequestMapping("/update")
    public String update(String firstName, String lastName, int zip, String password, String username) {
        User u = userService.update(firstName, lastName, zip, password, username);
        return u.toString();
    }

    // DELETE ONE
    @RequestMapping("/delete")
    public String delete(@RequestParam String username) {
        userService.delete(username){
            return "Deleted " + username;
        }

    // DELETE ALL
    @RequestMapping("/deleteall")
    public String deleteAll() {
        userService.deleteAll();
        return "Deleted all records";
    }

}