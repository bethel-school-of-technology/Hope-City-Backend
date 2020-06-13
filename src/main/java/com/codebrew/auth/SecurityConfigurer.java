package com.codebrew.auth;

import com.codebrew.service.MySQLUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private MySQLUserDetailsService userDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // accepted routes without authentication
        http.csrf().disable().authorizeRequests().antMatchers("/user", "/user/login", "/events/getall")
                .permitAll()
                // any other requests need authenticated with created token jwtRequestFilter;
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
    
    // public void addCorsMappings(CorsRegistry reg) {
    //     reg.addMapping("/**/**").allowedOrigins("http://localhost:4200").allowedMethods("POST", "PUT", "GET", "OPTIONS")
    //             .allowedHeaders("Origin", "X-REquested-With", "Content-Type", "Accept", "Authorization");
    // }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    //     CorsConfiguration corsConfig = new CorsConfiguration();
    //     corsConfig.applyPermitDefaultValues();
    //     corsConfig.setAllowedOrigins(Arrays.asList("/**"));
    //     corsConfig.setAllowedHeaders(Arrays.asList("POST", "GET", "PUT", "OPTIONS", "DELETE"));
    //     corsConfig.setAllowedMethods(
    //             Arrays.asList("Authorization", "Accept", "Content-Type", "X-REquested-With", "Origin"));
    //     corsConfig.setExposedHeaders(
    //             Arrays.asList("Authorization", "Accept", "Content-Type", "X-REquested-With", "Origin"));
    //     final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", corsConfig);
    //     return source;
    // }

}