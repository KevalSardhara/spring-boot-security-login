package com.javaspringboot.spring_security_learn1.service;

import com.javaspringboot.spring_security_learn1.entity.User;
import com.javaspringboot.spring_security_learn1.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
}
