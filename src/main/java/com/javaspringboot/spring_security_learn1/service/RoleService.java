package com.javaspringboot.spring_security_learn1.service;

import com.javaspringboot.spring_security_learn1.entity.Role;
import com.javaspringboot.spring_security_learn1.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role findByRoleName(String roleName) {
        return roleRepository.findByName(roleName).get();
    }
}
