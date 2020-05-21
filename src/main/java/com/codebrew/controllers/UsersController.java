package com.codebrew.controllers;

import java.util.*;

// import javax.validation.Valid;

// import javax.validation.Valid;

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
    @PostMapping("/register")
    public ResponseEntity<Users> newUser(@RequestBody Users user) {
        Users newUser = usersRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    // // UPDATE ONE
    // @PutMapping("/update/{email}")
    // public ResponseEntity<Users> updateUser(@PathVariable(value = "email") String
    // email,
    // @Valid @RequestBody Users user) {

    // Users foundUser = usersRepository.findByEmail(email);

    // if (foundUser == null) {
    // return ResponseEntity.notFound().header("Message", "invalid
    // request").build();
    // } else {
    // foundUser.setAddress(foundUser.getAddress());
    // foundUser.setCity(foundUser.getCity());
    // foundUser.setState(foundUser.getState());
    // foundUser.setZip(foundUser.getZip());
    // usersRepository.save(foundUser);
    // }
    // return ResponseEntity.ok(foundUser);
    // }

    // GET ONE for profile
    @GetMapping("/{email}")
    public Users findUser(@PathVariable(value = "email") String email) {
        return usersRepository.findByEmail(email);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user) {

        System.out.println(user.toString());
        return ResponseEntity.status(200).body(usersRepository.findByEmail(user.email));
    }

    // GET ALL
    @GetMapping()
    public List<Users> getUsers() {
        List<Users> foundUsers = usersRepository.findAll();
        return foundUsers;
    }

    // DELETE ONE
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Users> deleteUsers(@PathVariable(value = "email") String email) {
        Users foundUsers = usersRepository.findByEmail(email);

        if (foundUsers == null) {
            return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
        } else {
            usersRepository.delete(foundUsers);
        }
        return ResponseEntity.ok().build();
    }

}