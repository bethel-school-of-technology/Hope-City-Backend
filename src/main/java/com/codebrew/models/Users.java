package com.codebrew.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String address;
    public String city;
    public String state;
    public int zip;

    @Column(nullable = false, unique = true)
    public String email;
    public String password;
    public Boolean admin;


    public Users() {
    }

    public Users(Integer id, String address, String city, String state, int zip, String email, String password, Boolean admin) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return this.zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
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

    public Boolean isAdmin() {
        return this.admin;
    }

    public Boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Users id(Integer id) {
        this.id = id;
        return this;
    }

    public Users address(String address) {
        this.address = address;
        return this;
    }

    public Users city(String city) {
        this.city = city;
        return this;
    }

    public Users state(String state) {
        this.state = state;
        return this;
    }

    public Users zip(int zip) {
        this.zip = zip;
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

    public Users admin(Boolean admin) {
        this.admin = admin;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(address, users.address) && Objects.equals(city, users.city) && Objects.equals(state, users.state) && zip == users.zip && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(admin, users.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, city, state, zip, email, password, admin);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", zip='" + getZip() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", admin='" + isAdmin() + "'" +
            "}";
    }
    
}