package com.codebrew.controllers;

import java.io.IOException;
import java.util.*;

import javax.validation.Valid;

import com.codebrew.models.*;
import com.codebrew.repository.EventsRepository;
import com.codebrew.repository.UsersIdRepository;
import com.codebrew.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersIdRepository idRepo;

    // CREATE ONE working
    @PostMapping()
    public ResponseEntity<Users> newUser(@RequestBody Users user) throws IOException {
        Users newUser = usersRepository.save(user);
        System.out.println("new user added");
        return ResponseEntity.ok(newUser);
    }

    // GET ONE for profile working
    @GetMapping("/{email}")
    public Users findUser(@PathVariable(value = "email") String email) throws NotFoundException {
        System.out.println(" found by email");
        return usersRepository.findByEmail(email);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user) throws NotFoundException {
        System.out.println(user.toString());
        Users temp = usersRepository.findByEmail(user.email);
        // System.out.println(temp.toString());
        // System.out.println(temp.password);
        // System.out.println(user.password);
        if(temp.password.equals(user.password)) {
            return ResponseEntity.status(200).body(temp);
        } else {
            return ResponseEntity.status(403).body(null);
        }
    }

    // GET ALL working
    @GetMapping()
    public List<Users> getUsers() throws IOException {
        List<Users> foundUsers = usersRepository.findAll();
        System.out.println("get all called");
        return foundUsers;
    }

    // DELETE ONE working
    @DeleteMapping("/{email}")
    public ResponseEntity<Users> deleteUsers(@PathVariable(value = "email") String email) throws NotFoundException {
        Users foundUsers = usersRepository.findByEmail(email);

        if (foundUsers == null) {
            return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
        } else {
            usersRepository.delete(foundUsers);
        }
        System.out.println("user deleted");
        return ResponseEntity.ok().build();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody Users userDetails) throws NotFoundException {
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
            System.out.println("user updated");
            return ResponseEntity.ok(updatedUser);

        }
    }



        // @DeleteMapping("/attending/delete{id}")
        // UserEvent userEvent = new UserEvent();
        // userEvent.setId(id);
        // session.delete(userEvent);
    }

