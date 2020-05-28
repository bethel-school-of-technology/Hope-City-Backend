package com.codebrew.models;

import java.util.HashSet;
import java.util.Objects;
// import java.util.Set;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    public Integer id;
    public String city;
    public String state;
    public String firstName;
    public String lastName;
    public int zip;

    @Column(nullable = false, unique = true)
    public String email;
    public String password;
    public Boolean admin;
    private Set<UserEvent> userEvent = new HashSet<UserEvent>();

    @OneToMany(mappedBy = "user")
    public Set<UserEvent> getUserEvent() {
        return userEvent;
    }


    public void addEvent(UserEvent event) {
        this.userEvent.add(event);
    }

    public Users() {
    }

    public Users(Integer id, String city, String state, String firstName, String lastName, int zip, String email, String password, Boolean admin, Set<UserEvent> userEvent) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.userEvent = userEvent;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setUserEvent(Set<UserEvent> userEvent) {
        this.userEvent = userEvent;
    }

    public Users id(Integer id) {
        this.id = id;
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

    public Users firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Users lastName(String lastName) {
        this.lastName = lastName;
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

    public Users userEvent(Set<UserEvent> userEvent) {
        this.userEvent = userEvent;
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
        return Objects.equals(id, users.id) && Objects.equals(city, users.city) && Objects.equals(state, users.state) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && zip == users.zip && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(admin, users.admin) && Objects.equals(userEvent, users.userEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, state, firstName, lastName, zip, email, password, admin, userEvent);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", zip='" + getZip() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", admin='" + isAdmin() + "'" +
            ", userEvent='" + getUserEvent() + "'" +
            "}";
    }

   

}