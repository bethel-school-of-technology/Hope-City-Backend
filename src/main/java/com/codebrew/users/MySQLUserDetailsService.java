package com.codebrew.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MySQLUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  private List<SimpleGrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authList = new ArrayList<>();
    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
    return authList;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return new User(user.getUsername(), user.getPassword(), getAuthorities());
  }

  public UserDetails Save(Users newUser) {
    newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
    Users savedUser = userRepository.save(newUser);
    return new User(savedUser.getUsername(), savedUser.getPassword(), getAuthorities());
  }

}
