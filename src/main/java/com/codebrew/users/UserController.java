package com.codebrew.users;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserIdRepository userIdRepository;

  @Autowired
  private MySQLUserDetailsService userService;

  // CREATE
  @PutMapping("/user/{id}")
  public ResponseEntity<Users> newUser(@PathVariable(value = "id") Long id, @RequestBody Users username)
      throws Exception {
    Users user = userIdRepository.findById(id);

    if (user == null) {
      return ResponseEntity.notFound().header("Message", "User not found").build();
    } else {
      user.setPassword(user.getPassword());
      user.setUsername(user.getUsername());
      user.setAddress(user.getAddress());
      user.setState(user.getState());
      user.setCity(user.getCity());
      user.setZip(user.getZip());

      userRepository.save(user);
    }
    return ResponseEntity.ok(user);

  }

  // CREATE
  // @PostMapping("/register")
  // public void register(@RequestBody Users newUser) {
  // userService.Save(newUser);
  // }
  @PostMapping("*/register")
  public ResponseEntity<Users> registerUser(@RequestParam("username") String username,
      @RequestParam("password") String password,
      Model model) {
    User foundUser = userRepository.findByUsername(username);
    if (foundUser == null) {
      Users newUser = new Users();
      newUser.setUsername(username);
      newUser.setPassword(password);
      userService.Save(newUser);
      return ResponseEntity.ok(newUser);
    } else {
      model.addAttribute("exists", true);

    }
    return null;
  }
  // UPDATE
  @PutMapping("/update/{id}")
  public String update(@RequestBody Users u) {
    u.setUsername(u.getUsername());
    u.setAddress(u.getAddress());
    u.setCity(u.getCity());
    u.setState(u.getState());
    u.setZip(u.getZip());

    userRepository.save(u);

    return u.toString();
  }

  // GET ALL
  @GetMapping("/all")
  public List<Users> findAll() {
    return userRepository.findAll();
  }

  // GET ONE
  @GetMapping("user/{id}")
  public ResponseEntity<Users> getUser(@PathVariable("id") Long id) {
    Users foundUser = userIdRepository.findById(id);

    if (foundUser == null) {
      return ResponseEntity.notFound().header("message", "Nothing found with that id").build();
    }
    return ResponseEntity.ok(foundUser);
  }

  // DELETE ONE
  @DeleteMapping("/delete/{username}")
  public void delete(@RequestParam("username") String username, @RequestParam("password") String password,
      Model model) {
    userRepository.findByUsername(username);

  }

}
