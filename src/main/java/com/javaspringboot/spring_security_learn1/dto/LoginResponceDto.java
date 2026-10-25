package com.javaspringboot.spring_security_learn1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponceDto {
    private String accessToken;

    private List<String> authorities = new ArrayList<>();
}
