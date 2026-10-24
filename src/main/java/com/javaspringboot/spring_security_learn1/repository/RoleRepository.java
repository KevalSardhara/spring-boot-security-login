package com.javaspringboot.spring_security_learn1.repository;

import com.javaspringboot.spring_security_learn1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
