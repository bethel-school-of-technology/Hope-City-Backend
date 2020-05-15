package com.codebrew.users;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;
  private String password;

  public String address;
  public String city;
  public String state;
  public int zip;

  public User() {
  }

  public User(Long id, String username, String password, String address, String city, String state, int zip) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
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

  public User id(Long id) {
    this.id = id;
    return this;
  }

  public User username(String username) {
    this.username = username;
    return this;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  public User address(String address) {
    this.address = address;
    return this;
  }

  public User city(String city) {
    this.city = city;
    return this;
  }

  public User state(String state) {
    this.state = state;
    return this;
  }

  public User zip(int zip) {
    this.zip = zip;
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
    return Objects.equals(id, user.id) && Objects.equals(username, user.username)
        && Objects.equals(password, user.password) && Objects.equals(address, user.address)
        && Objects.equals(city, user.city) && Objects.equals(state, user.state) && zip == user.zip;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, address, city, state, zip);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", password='" + getPassword() + "'"
        + ", address='" + getAddress() + "'" + ", city='" + getCity() + "'" + ", state='" + getState() + "'" + ", zip='"
        + getZip() + "'" + "}";
  }
}
