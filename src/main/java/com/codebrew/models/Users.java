package com.codebrew.models;

import javax.persistence.*;


@Entity
@Table(name ="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(nullable = false, unique = true)
    public String username;
    public String password;

    public Users() {
        super();
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users id(Integer id) {
        this.id = id;
        return this;
    }

    public Users username(String username) {
        this.username = username;
        return this;
    }

    public Users password(String password) {
        this.password = password;
        return this;
    }


 

}