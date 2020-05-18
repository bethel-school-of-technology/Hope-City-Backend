package com.codebrew.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codebrew.users.UserRepository;
import com.codebrew.models.Admin;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.hibernate.ejb.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.RecognitionException;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Admin")
    public List<Admin> getAllAdmin() {
        return userRepository.findAll();
    }

@GetMapping("/Admin/{id}")
public ResponseEntity<Admin> getAdminbyId(@PathVariable(value = "id") long adminId)
 throws ResourceNotFoundException {
     Admin admin =
        userRepository
          .findById((adminId))
            .orElseThrow(() -> new RecoursesNotFoundException("Admin not found on : :" + adminId))
            return ResponseEntity.ok().body(Admin);
 }

    @PostMapping("/Admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return UserRepository.save(admin);
    }

 @PutMapping("/Admin/{id}")
 public ResponseEntity<Admin> updateUser(
      @PathVariable(value = "id") Long adminId, @Valid @RequestBody Admin adminDetails)
      throws RecognitionException {
          Admin admin =
            userRepository
              .findById(adminId)
              .OrElseThrow(() -> new RecourseNotfoundException("Admin is not found on ::" + adminId))


              admin.setEmail(adminDetails.getEmail());
              admin.setChurchName(adminDetails.churchName());
             
      }











}