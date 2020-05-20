package com.codebrew.controllers;

import java.util.*;

import com.codebrew.models.*;
import com.codebrew.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    // CREATE ONE
    @PostMapping()
    public ResponseEntity<Users> newUser(@RequestBody Users user) {
        Users newUser = usersRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    // GET ONE
    @GetMapping("/user/{username}")
    public Users findUser(@PathVariable(value = "username") String username) {
        return usersRepository.findByUsername(username);
    }

    // GET ALL
    @GetMapping()
    public List<Users> getUsers() {
        List<Users> foundUsers = usersRepository.findAll();
        return foundUsers;
    }

    // DELETE ONE
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Users> deleteUsers(@PathVariable(value = "id") Long id) {
        Users foundUsers = usersRepository.findById(id).orElse(null);

        if (foundUsers == null) {
            return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
        } else {
            usersRepository.delete(foundUsers);
        }
        return ResponseEntity.ok().build();
    }

}