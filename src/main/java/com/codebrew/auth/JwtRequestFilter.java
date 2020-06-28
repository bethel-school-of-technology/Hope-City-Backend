package com.codebrew.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codebrew.service.MySQLUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



// once per request filter that runs for each request from the front end.  checks the header for the authorization header, checks for the "Bearer " string with substring, then extracts email, and security context holder, if all that checks out then a usernamepasswordauthentication token is administered and approval is granted for access. 
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MySQLUserDetailsService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
                System.out.println("calling authFilter");
                
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        String email = null;
        String jwt = null;
        System.out.println("setting null values to email and jwt");
        
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            System.out.println("header starts with Bearer" + authorizationHeader);
            System.out.println("line 41 passed");

            jwt = authorizationHeader.substring(7);

            System.out.println("checking header for proper substring");
            email = jwtUtil.extractEmail(jwt);

            System.out.println("line 53, extracted email from jwt " + email);
        }
    System.out.println("line 47");
    if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        System.out.println("line 49 email is not null and getting context from security context holder: " + email);

        UserDetails userDetails = this.userService.loadUserByUsername(email);

        System.out.println("line 61, user details: " + email );

        if (userDetails != null && jwtUtil.validateToken(jwt, userDetails)) {

            System.out.println("line 65 validating token: " + jwt + userDetails);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
            System.out.println("line 69 ");
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            response.addHeader(authorizationHeader, jwt);
            request.setAttribute("userDetails", userDetails);
           
            System.out.println("line 67 " + authorizationHeader + jwt);
        }
    }
        System.out.println("line 78");
        chain.doFilter(request, response);

    }
}