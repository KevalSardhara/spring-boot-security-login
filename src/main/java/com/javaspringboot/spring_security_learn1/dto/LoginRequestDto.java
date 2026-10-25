package com.javaspringboot.spring_security_learn1.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String username;

    private String password;
}
