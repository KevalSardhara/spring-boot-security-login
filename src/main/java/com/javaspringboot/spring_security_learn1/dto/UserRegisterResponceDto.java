package com.javaspringboot.spring_security_learn1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterResponceDto {

    private String username;

    private String message;

    public UserRegisterResponceDto(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
