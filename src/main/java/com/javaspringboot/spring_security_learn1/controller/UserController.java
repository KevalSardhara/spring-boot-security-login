package com.javaspringboot.spring_security_learn1.controller;

import com.javaspringboot.spring_security_learn1.dto.UserRegisterRequestDto;
import com.javaspringboot.spring_security_learn1.dto.UserRegisterResponceDto;
import com.javaspringboot.spring_security_learn1.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final AuthService authService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<String> getAllUsers() {
        String password = "keval1234";
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("Random Password : " + password + "\nEncoded Password : " + encodedPassword);
        System.out.println("Password Match : " + passwordEncoder.matches("keval123", "$2a$10$izjjasBNvTvdbzHy8lShj.LtVAPVKBvCCuuP/FhZR2RhTO6MHM.N."));

        return ResponseEntity.status(HttpStatus.OK).body("Get All users successfully!!!");
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponceDto> userRegister(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        UserRegisterResponceDto userRegisterResponceDto = authService.registerUser(userRegisterRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userRegisterResponceDto);
    }

//    @PostMapping("/login")
//    public ResponseEntity<Boolean> userLogin(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
//        Boolean isLogin = authService.login(userRegisterRequestDto);
//        return ResponseEntity.status(HttpStatus.OK).body(isLogin);
//    }

    @GetMapping("/csrf")
    public ResponseEntity<CsrfToken> getToken(CsrfToken csrfToken) {
        return ResponseEntity.status(HttpStatus.OK).body(csrfToken);
    }
}
