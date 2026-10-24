package com.javaspringboot.spring_security_learn1.service;


import com.javaspringboot.spring_security_learn1.dto.UserRegisterRequestDto;
import com.javaspringboot.spring_security_learn1.dto.UserRegisterResponceDto;
import com.javaspringboot.spring_security_learn1.entity.Role;
import com.javaspringboot.spring_security_learn1.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AuthService {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
//    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(
            UserService userService,
            RoleService roleService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

//    public AuthService(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }

    public UserRegisterResponceDto registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        User user = new User();
        user.setUsername(userRegisterRequestDto.getUsername());
        String encodedPassword = passwordEncoder.encode(userRegisterRequestDto.getPassword());
        user.setPassword(encodedPassword);
        Role role = roleService.findByRoleName("ROLE_USER");
        user.getRole().add(role);
        user.setEnabled(true);

        userService.saveUser(user);


        return new UserRegisterResponceDto(user.getUsername(), "User registered successfully");
    }

    public Boolean login(UserRegisterRequestDto userRegisterRequestDto) {
        User user = userService.findByUsername(userRegisterRequestDto.getUsername());
        boolean verifyLoginCredentials = passwordEncoder.matches(userRegisterRequestDto.getPassword(), user.getPassword());
        return Boolean.valueOf(verifyLoginCredentials);
    }
}
