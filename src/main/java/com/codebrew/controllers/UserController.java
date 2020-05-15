package com.codebrew.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codebrew.auth.MySQLUserDetailsService;
import com.codebrew.repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private MySQLUserDetailsService userService;

  @PostMapping("/register")
  public void register(@RequestBody User newUser) {
    userService.Save(newUser);
  }
  
  @DeleteMapping("/delete")
  public void delete(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
	  	UserRepository.findByUsername(username);	
	  
  }
}
