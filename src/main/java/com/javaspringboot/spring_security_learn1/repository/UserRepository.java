package com.javaspringboot.spring_security_learn1.repository;

import com.javaspringboot.spring_security_learn1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
