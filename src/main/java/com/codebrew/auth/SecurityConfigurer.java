package com.codebrew.auth;

import java.beans.Customizer;
import java.util.Arrays;

import com.codebrew.service.MySQLUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // accepted routes without authentication
        http.csrf().disable().authorizeRequests()
                .antMatchers("/user", "/user/login", "/events/getall", "/events/get/**",
                        "/image/get/**")
                .permitAll()
                // any other requests need authenticated with created token jwtRequestFilter;
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        // http.cors(this.corsConfigurationSource());
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

    // public void addCorsMappings(CorsRegistry reg) {
    // reg.addMapping("/**/**").allowedOrigins("http://localhost:4200").allowedMethods("POST",
    // "PUT", "GET", "OPTIONS")
    // .allowedHeaders("Origin", "X-REquested-With", "Content-Type", "Accept",
    // "Authorization");
    // }

    // // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    // CorsConfiguration corsConfig = new CorsConfiguration();
    // corsConfig.applyPermitDefaultValues();
    // corsConfig.setAllowedOrigins(Arrays.asList("/**"));
    // corsConfig.setAllowedHeaders(Arrays.asList("POST", "GET", "PUT", "OPTIONS",
    // "DELETE"));
    // corsConfig.setAllowedMethods(
    // Arrays.asList("Authorization", "Accept", "Content-Type", "X-REquested-With",
    // "Origin"));
    // corsConfig.setExposedHeaders(
    // Arrays.asList("Authorization", "Accept", "Content-Type", "X-REquested-With",
    // "Origin"));
    // final UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // source.registerCorsConfiguration("/**", corsConfig);
    // return source;
    // }

    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }
}