package com.codebrew.models;


public class AuthenticationResponse {

    public String jwt;

    public String id;
    public String firstName;
    public String lastName;

    public String email;

    public String username;
    public String password;

    public String city;
    public String state;
    public String zip;

    public Boolean admin;

    public AuthenticationResponse(String jwt, Users user) {
        this.jwt = jwt;
        try {
            this.id = user.id.toString();

            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.email = user.email;
            this.username = user.username;
            // skipping password

            this.city = user.city;
            this.state = user.state;
            this.zip = ((Integer) (user.zip)).toString();
            this.admin = user.admin;
        } catch (NullPointerException er) {
            System.out.println("there was an null err i dont want to show it");
        }
        ;
    }
}