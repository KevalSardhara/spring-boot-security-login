package com.javaspringboot.spring_security_learn1.controller;

import com.javaspringboot.spring_security_learn1.entity.Role;
import com.javaspringboot.spring_security_learn1.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.OK).body("Role created successfully!!!");
    }
}
