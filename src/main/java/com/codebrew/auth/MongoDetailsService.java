// package com.codebrew.auth;

// import java.util.ArrayList;
// import java.util.List;

// import com.codebrew.repository.*;


// import org.apache.catalina.User;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;

// public class MongoDetailsService implements UserDetailsService {

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @Override
//     public UserDetails loadUserByUsername(String username) {
//         org.springframework.boot.autoconfigure.security.SecurityProperties.User user = userRepository
//                 .findByUsername(username);
//         if (user == null) {
//             throw new UsernameNotFoundException(username);
//         }
//         return new org.springframework.security.core.userdetails.User(user.getName(),
//                 user.getPassword(),
//                 getAuthorities());
//     }

//     public UserDetails Save(User newUser) {
//         newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
//         User savedUser = userRepository.save(newUser);
//         return new org.springframework.security.core.userdetails.User(savedUser.getUsername(), savedUser.getPassword(),
//                 getAuthorities());
//     }

//     private List<SimpleGrantedAuthority> getAuthorities() {
//         List<SimpleGrantedAuthority> authList = new ArrayList<>();
//         authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//         return authList;
//     }

// 	public UserDetailsService passwordEncoder(PasswordEncoder passwordEncoder) {
// 		return null;
// 	}
// }