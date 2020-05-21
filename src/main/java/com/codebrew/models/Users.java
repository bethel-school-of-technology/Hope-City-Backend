package com.codebrew.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(nullable = false, unique = true)
    public String email;
    public String password;
    public Boolean admin;

    public Users() {
        super();
    }

    public Users(String email, String password, Boolean admin) {
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public Users(Integer id, String email, String password, Boolean admin) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Users email(String email) {
        this.email = email;
        return this;
    }

    public Users password(String password) {
        this.password = password;
        return this;
    }

    public Boolean getAdmin() {
        return this.admin;

    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}