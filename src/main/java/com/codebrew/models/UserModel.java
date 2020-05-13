package com.codebrew.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String church;
    private int zip;
    private String password;
    private String username;

    public UserModel() {
    }

    public UserModel(long id, String firstName, String lastName, String church, int zip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.church = church;
        this.zip = zip;
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

    public UserModel id(long id) {
        this.id = id;
        return this;
    }

    public UserModel firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserModel lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserModel church(String church) {
        this.church = church;
        return this;
    }

    public UserModel zip(int zip) {
        this.zip = zip;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return id == userModel.id && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName) && Objects.equals(church, userModel.church) && zip == userModel.zip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, church, zip);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", church='" + getChurch() + "'" +
            ", zip='" + getZip() + "'" +
            "}";
    }




    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

}