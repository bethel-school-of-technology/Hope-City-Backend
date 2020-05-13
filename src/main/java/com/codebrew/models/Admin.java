package com.codebrew.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String churchName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(long id, String churchName, String address, String city, String state, int zip) {
        this.id = id;
        this.churchName = churchName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChurchName() {
        return this.churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
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

    public Admin id(long id) {
        this.id = id;
        return this;
    }

    public Admin churchName(String churchName) {
        this.churchName = churchName;
        return this;
    }

    public Admin address(String address) {
        this.address = address;
        return this;
    }

    public Admin city(String city) {
        this.city = city;
        return this;
    }

    public Admin state(String state) {
        this.state = state;
        return this;
    }

    public Admin zip(int zip) {
        this.zip = zip;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin churchAdminModel = (Admin) o;
        return id == churchAdminModel.id && Objects.equals(churchName, churchAdminModel.churchName)
                && Objects.equals(address, churchAdminModel.address) && Objects.equals(city, churchAdminModel.city)
                && Objects.equals(state, churchAdminModel.state) && zip == churchAdminModel.zip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, churchName, address, city, state, zip);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", churchName='" + getChurchName() + "'" + ", address='" + getAddress()
                + "'" + ", city='" + getCity() + "'" + ", state='" + getState() + "'" + ", zip='" + getZip() + "'"
                + "}";
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

}