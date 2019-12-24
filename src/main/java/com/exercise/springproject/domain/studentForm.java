package com.exercise.springproject.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class studentForm {
    @NotNull(message = "Username shouldn't be null")
    private int username;
    @NotBlank
    private String password;
    @NotNull(message = "Confirm password shouldn't be null")
   // private String confirmPassword;

    public int getUsername() {
        return username;
    }

    public void setUsername(int id) {
        this.username = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
