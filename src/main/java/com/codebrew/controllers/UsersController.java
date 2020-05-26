package com.codebrew.controllers;

import java.util.*;

import javax.validation.Valid;

import com.codebrew.models.*;
import com.codebrew.repository.UsersIdRepository;
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

    @Autowired
    private UsersIdRepository idRepo;

    // CREATE ONE working
    @PostMapping()
    public ResponseEntity<Users> newUser(@RequestBody Users user) {
        Users newUser = usersRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    // GET ONE for profile working
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

    // GET ALL working
    @GetMapping()
    public List<Users> getUsers() {
        List<Users> foundUsers = usersRepository.findAll();
        return foundUsers;
    }

    // DELETE ONE working
    @DeleteMapping("/{email}")
    public ResponseEntity<Users> deleteUsers(@PathVariable(value = "email") String email) {
        Users foundUsers = usersRepository.findByEmail(email);

        if (foundUsers == null) {
            return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
        } else {
            usersRepository.delete(foundUsers);
        }
        return ResponseEntity.ok().build();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody Users userDetails) {
        Users user = idRepo.findUserById(id);

        if (userDetails == null) {
            return ResponseEntity.notFound().header("Message", "no user found with that Id").build();
        } else {

            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setCity(userDetails.getCity());
            user.setState(userDetails.getState());
            user.setZip(userDetails.getZip());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setAdmin(userDetails.getAdmin());

            final Users updatedUser = idRepo.save(user);
            return ResponseEntity.ok(updatedUser);

        }

    }
}
