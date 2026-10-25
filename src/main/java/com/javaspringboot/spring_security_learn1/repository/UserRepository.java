package com.javaspringboot.spring_security_learn1.repository;

import com.javaspringboot.spring_security_learn1.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    @EntityGraph(attributePaths = {"role"})
    Optional<User> findByUsername(String username);
}
