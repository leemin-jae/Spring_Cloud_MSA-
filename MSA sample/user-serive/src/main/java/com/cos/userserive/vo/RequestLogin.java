package com.cos.userserive.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestLogin {
    private String email;
    private String password;
}
