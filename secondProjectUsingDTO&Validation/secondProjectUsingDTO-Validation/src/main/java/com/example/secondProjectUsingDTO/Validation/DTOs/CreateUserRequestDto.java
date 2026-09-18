package com.example.secondProjectUsingDTO.Validation.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequestDto {
    @NotBlank(message = "User name is required")
    private String userName;

    @Email(message = "Please enter a valid email address")
    private String userEmail;

    @Min(value = 18, message = "User age must be at least 18")
    private Integer userAge;

    @NotBlank(message = "User city is required")
    private String userCity;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }
}
