package com.codebrew.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MySQLUserDetailsService userService;

  @Autowired
  private UserIdRepository userIdRepository;

  // CREATE
  @PostMapping("/register")
  public void register(@RequestBody User newUser) {
    userService.Save(newUser);
  }

  // DELETE
  @DeleteMapping("/delete")
  public void delete(@RequestParam("username") String username, @RequestParam("password") String password,
      Model model) {
    userRepository.findByUsername(username);

  }
  
  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    User foundUser = userIdRepository.findById(id);

    if (foundUser == null) {
      return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
    }
    return ResponseEntity.ok(foundUser);
  }

}
