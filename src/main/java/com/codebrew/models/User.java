package com.codebrew.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Field
    private long id;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String church;
    @Field
    private int zip;
    @Field
    private String password;
    @Field
    private String username;


    public User(long id, String firstName, String lastName, String church, int zip, String password, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.church = church;
        this.zip = zip;
        this.password = password;
        this.username = username;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getChurch() {
        return this.church;
    }

    public void setChurch(String church) {
        this.church = church;
    }

    public int getZip() {
        return this.zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User id(long id) {
        this.id = id;
        return this;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User church(String church) {
        this.church = church;
        return this;
    }

    public User zip(int zip) {
        this.zip = zip;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(church, user.church) && zip == user.zip && Objects.equals(password, user.password) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, church, zip, password, username);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", church='" + getChurch() + "'" +
            ", zip='" + getZip() + "'" +
            ", password='" + getPassword() + "'" +
            ", username='" + getUsername() + "'" +
            "}";
    }


}