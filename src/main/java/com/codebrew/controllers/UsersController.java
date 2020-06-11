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
    public Users register(@RequestBody Users newUser) {
        userService.Save(newUser);
        System.out.println("new user created" + newUser);
        return newUser;
    }

    // ===============================================================================================================================================================================================================
    @Autowired
    private JwtUtil jwtTokenUtil;

    // @Autowired
    // private AuthenticationManager authenticationManager;
    // LOGIN WORKING with Granted Authorities & Token
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Users user) throws Exception {
        try{
            new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect email or password", e);
        }
        UserDetails temp = userService.loadUserByUsername(user.email);
        System.out.println("user : " + user + "found");

        if (BCrypt.checkpw(user.password, temp.getPassword()) == true) {
            System.out.println("user Info: " + temp);
            final String jwt = jwtTokenUtil.generateToken(user);   
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } else {
            System.out.println("Invalid email or password, unauthorized");
            return ResponseEntity.status(403).body(null);
        }
    }
    // // LOGIN WORKING as Users.  returns full users information.
    // @PostMapping("/login")
    // public ResponseEntity<Users> login(@RequestBody Users user) throws UsernameNotFoundException {
    //     Users temp = usersRepository.findByEmail(user.email);
    //     System.out.println("user : " + user + "found");
    //     if (BCrypt.checkpw(user.password, temp.password) == true) {
    //         System.out.println("user Info: " + temp);
    //         return ResponseEntity.status(200).body(temp);
    //     } else {
    //         return ResponseEntity.status(403).body(null);
    //     }
    // }

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
            user.setAdmin(userDetails.getAdmin());
            final Users updatedUser = idRepo.save(user);
            System.out.println("updated " + updatedUser.getUsername());
            return ResponseEntity.ok(updatedUser);

        }

    }

    // UPDATE PASSWORD WORKING
    @RequestMapping(value = "/update/password/{id}", produces = "application/json", method = { RequestMethod.PUT })
    public ResponseEntity<UserDetails> updateUserPassword(
            @PathVariable(value = "id") Integer id,
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
    
    public ResponseEntity<Users> updateAdmin(
            @PathVariable(value = "id") Integer id,
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
    public ResponseEntity<Users> deleteUsers(@PathVariable(value = "email")
    String email) throws NotFoundException {
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
