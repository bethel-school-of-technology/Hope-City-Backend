package com.codebrew.users;

import javax.persistence.Id;

public class UserLogin extends Users {
    @Id
    Long id;
    private String username;
    private String password;

    public UserLogin(String username, String password) {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}