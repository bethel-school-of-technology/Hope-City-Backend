package com.codebrew.controllers;

import java.io.IOException;
import java.util.*;

import javax.validation.Valid;

// import javax.validation.Valid;
import com.codebrew.models.*;
// import com.codebrew.repository.UserIdRepository;
import com.codebrew.repository.UserIdRepository;
import com.codebrew.repository.UsersRepository;
import com.codebrew.service.MySQLUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UsersController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserIdRepository idRepo;

    @Autowired
    MySQLUserDetailsService userService;

    // ENCODING PASSWORD WORKING
    @PostMapping()
    public Users register(@RequestBody Users newUser) {
        userService.Save(newUser);
        System.out.println("new user created" + newUser);
        return newUser;
    }

    // ===============================================================================================================================================================================================================
    // login
    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user) throws
    UsernameNotFoundException {
    System.out.println(user.toString());
    Users temp = usersRepository.findByEmail(user.email);
    // System.out.println(temp.toString());
    // System.out.println(temp.password);
    // System.out.println(user.password);
    if (passwordEncoder.encode(temp.password).equals(user.password)) {
    return ResponseEntity.status(200).body(temp);
    } else {
    return ResponseEntity.status(403).body(null);
    }
    }
    // login
    // @PostMapping("/login")
    // public UserDetails login(@RequestBody Users user) throws UsernameNotFoundException {
    //     System.out.println(user.toString());
    //     UserDetails temp = userService.loadUserByUsername(user.email);
    //     if (temp.password.equals(user.password)) {
    //         return temp;
    //     } else
    //     // if (temp.getPassword().equals(user.password)) {
    //     //     return (UserDetails) ResponseEntity.status(200).body(temp);
    //     // } else {
    //     //     return (UserDetails) ResponseEntity.status(403).body(null);
    //     // }
    //     return null;
    // }
    // ===============================================================================================================================================================================================================

    // GET ONE for profile working
    @RequestMapping(value = "/{email}", produces = "application/json", method = { RequestMethod.GET })
    public Users findUser(@PathVariable(value = "email") String email) throws UsernameNotFoundException {
        System.out.println(" found by email");
        return usersRepository.findByEmail(email);
    }
    // ===============================================================================================================================================================================================================

    // GET ALL working
    @RequestMapping(produces = "application/json", method = { RequestMethod.GET })
    public List<Users> getUsers() throws IOException {
        List<Users> foundUsers = usersRepository.findAll();
        System.out.println("get all called" + foundUsers);
        return foundUsers;
    }

    // ===============================================================================================================================================================================================================
    // UPDATE
    @RequestMapping(value = "/update/{id}", produces = "application/json", method = { RequestMethod.PUT })
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
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setAdmin(userDetails.getAdmin());

            final Users updatedUser = idRepo.save(user);
            System.out.println("updated " + updatedUser.getUsername());
            return ResponseEntity.ok(updatedUser);

        }

    }

    // // DELETE ONE working
    // @DeleteMapping("/{email}")
    // public ResponseEntity<Users> deleteUsers(@PathVariable(value = "email")
    // String email) throws NotFoundException {
    // Users foundUsers = usersRepository.findByEmail(email);

    // if (foundUsers == null) {
    // return ResponseEntity.notFound().header("Message", "Nothing found with that
    // id").build();
    // } else {
    // usersRepository.delete(foundUsers);
    // }
    // System.out.println("user deleted");
    // return ResponseEntity.ok().build();
    // }
    // ===============================================================================================================================================================================================================

}
