package com.vasyerp.hikariissue.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vasyerp.hikariissue.models.User;
import com.vasyerp.hikariissue.repo.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> findOne(String name) {
        return userRepository.findByName(name);
    }
}