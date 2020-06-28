package com.codebrew.controllers;

import java.io.IOException;
import java.util.*;

import javax.validation.Valid;

import com.codebrew.auth.JwtUtil;
// import javax.validation.Valid;
import com.codebrew.models.*;
// import com.codebrew.repository.UserIdRepository;
import com.codebrew.repository.UserIdRepository;
import com.codebrew.repository.UsersRepository;
import com.codebrew.service.MySQLUserDetailsService;

import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;


// controller for users, includes endpoints for registration, login, getone, getall, delete, update, updatepassword, & update admin status.
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserIdRepository idRepo;

    @Autowired
    MySQLUserDetailsService userService;

    // ENCODING PASSWORD WORKING
    @PostMapping()
    public ResponseEntity<?> register(@RequestBody Users newUser) throws DuplicateMappingException {
// takes in Users object, email, password entered and saves them along with other entered details into database. Password is encoded through the userService.Save() defined in the MySQLUserDetailsService that includes the password encoder. 
        if (usersRepository.findByEmail(newUser.email) == null) {
            userService.Save(newUser);
            System.out.println("new user created" + newUser);
            return ResponseEntity.ok(usersRepository.findByEmail(newUser.email));
        } else {
            
            System.out.println("not able to register new user");
            return ResponseEntity.status(400).body("not valid signup info");
        }
    }

    // ===============================================================================================================================================================================================================
    @Autowired
    private JwtUtil jwtTokenUtil;

    
    // LOGIN WORKING with Granted Authorities & Token
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody Users user) throws Exception {
        // takes in email and password from JSON.
        try {
            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
            System.out.println("Creating token with email and password");
        } catch (BadCredentialsException e) {

            System.out.println("bad credentials");

            // throw new Exception("Incorrect email or password", e);
            return ResponseEntity.status(403).body("Incorrect email or password");
        }
        System.out.println("valid credentials received");

        UserDetails temp = userService.loadUserByUsername(user.email);

        System.out.println("user : " + user + "found");
            // takes entered password and compares it to the hashed password of the user found by the entered email. 
        if (BCrypt.checkpw(user.password, temp.getPassword()) == true) {

            System.out.println("password authenticated");

            System.out.println("user Info: " + temp);
            
            // generates token if login is successful. 
            final String jwt = jwtTokenUtil.generateToken(user);
            // generates token and sets the header for authorization. 
            return ResponseEntity.ok(new AuthenticationResponse(jwt, usersRepository.findByEmail(user.email)));
        } else {
            System.out.println("Invalid email or password, unauthorized");
            return ResponseEntity.status(403).body("Invalid email or password, unauthorized");
        }
    }

    /////////////////////////////////////////////////////////////////

    // GET ONE for profile working
    @RequestMapping(value = "/{email}", produces = "application/json", method = { RequestMethod.GET })
    public Users findUser(@PathVariable(value = "email") String email) throws UsernameNotFoundException {
        System.out.println(" found by email");
        return usersRepository.findByEmail(email);
    }
    // ////////////////////////////////////////////////////////////

    // GET ALL working
    @RequestMapping(produces = "application/json", method = { RequestMethod.GET })
    public List<Users> getUsers() throws IOException {
        List<Users> foundUsers = usersRepository.findAll();
        System.out.println("get all called" + foundUsers);
        return foundUsers;
    }

    // /////////////////////////////////////////////////////////////
    // UPDATE DETAILS WORKING
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
            final Users updatedUser = idRepo.save(user);
            System.out.println("updated " + updatedUser.getUsername());
            return ResponseEntity.ok(updatedUser);
// sets new attributes for each var. in the model, excluding the password and admin.  those are done with separate endpoints. 
        }

    }

    // UPDATE PASSWORD WORKING
    @RequestMapping(value = "/update/password/{id}", produces = "application/json", method = { RequestMethod.PUT })
    public ResponseEntity<UserDetails> updateUserPassword(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody Users userDetails) throws NotFoundException {
        Users user = idRepo.findUserById(id);

        if (userDetails == null) {
            return ResponseEntity.notFound().header("Message", "no user found with that Id").build();
        } else {
            user.setPassword(userDetails.getPassword());
            user.setAdmin(userDetails.getAdmin());

            final UserDetails updatedUser = userService.Save(user);
            System.out.println("updated " + updatedUser);
            return ResponseEntity.ok(updatedUser);

        }
    }

    // //////////////////////////////////////////////////////////////////////////
    // UPDATE ADMIN STATUS
    @RequestMapping(value = "/role/{id}", produces = "application/json", method = { RequestMethod.PUT })

    public ResponseEntity<Users> updateAdmin(@PathVariable(value = "id") Integer id,
            @Valid @RequestBody Users userDetails) throws NotFoundException {
        Users user = idRepo.findUserById(id);

        if (userDetails == null) {
            return ResponseEntity.notFound().header("Message", "no user found with that Id").build();
        } else {
            user.setAdmin(true);
            final Users updatedUser = usersRepository.save(user);
            System.out.println("updated " + updatedUser.getUsername());
            return ResponseEntity.ok(updatedUser);

        }
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
}
