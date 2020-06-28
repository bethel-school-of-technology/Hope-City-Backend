package com.codebrew.service;

import java.util.ArrayList;
import java.util.List;

import com.codebrew.models.Users;
import com.codebrew.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


// primarily taken from course content in backendFoundations, modification was necessary. 
@Service
public class MySQLUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    // loads userDetails by username(or email in our case)
    @Override
    public UserDetails loadUserByUsername(String email) {
        Users user = usersRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities());
    }


// saves new UserDetails (spring built in model) -> type Users, and encodes password with BCrypt on save. 
    public UserDetails Save(Users newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Users savedUser = usersRepository.save(newUser);
        return new org.springframework.security.core.userdetails.User(savedUser.getEmail(), savedUser.getPassword(),
                getAuthorities());
    }



    private List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authList;
    }
}