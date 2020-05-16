package com.codebrew.controllers;


import com.codebrew.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
    

@Autowired
private UserRepository adminRepository;


@GetMapping("/admin")
public List<Admin> getAllAdmin() {
    return userRepository.findAll();
}
}