package com.example.demorest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be null")
    private String username;
    @NotBlank(message = "Password cannot be null")
    private String password;
    @Min(value = 1, message = "Age should be greater than 0")
    @Max(value = 149, message = "Age should be less than 150")
    private int age;

    public ApplicationUser() {

    }

    public ApplicationUser(String username, String password, int age) {
        super();
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public long getId() {
        return this.id;
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}