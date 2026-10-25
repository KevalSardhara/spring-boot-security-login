package com.javaspringboot.spring_security_learn1.controller;

import com.javaspringboot.spring_security_learn1.dto.LoginRequestDto;
import com.javaspringboot.spring_security_learn1.dto.LoginResponceDto;
import com.javaspringboot.spring_security_learn1.service.JwtService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponceDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
                loginRequestDto.getUsername(),
                loginRequestDto.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationRequest);
        String token = jwtService.generateToken(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponceDto(token, authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()));
    }
}
