package com.cos.userserive.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two")
    @Email
    private String email;
    @NotNull(message = "name cannot be null")
    @Size(min = 2, message = "Name not be less than two")
    private String name;
    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password not be less than 8")
    private String pwd;
}
