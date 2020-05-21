package com.codebrew.models;

import javax.persistence.*;


@Entity
@Table(name ="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(nullable = false, unique = true)
    public String email;
    public String password;

    public Users() {
        super();
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getemail() {
        return this.email;
    }

    public void setemail(String email) {
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


 

}