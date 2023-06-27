package com.vasyerp.hikariissue.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasyerp.hikariissue.models.User;
import com.vasyerp.hikariissue.service.DocumentService;
import com.vasyerp.hikariissue.service.UserService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final DocumentService documentService;

    public UserController(UserService userService, DocumentService documentService) {
        this.userService = userService;
        this.documentService = documentService;
    }

    @GetMapping("/{name}/document")
    public ResponseEntity<?> findOne(@PathVariable String name) throws InterruptedException {
        log.info("Looking for user [{}]"+ name);
        Optional<User> user = userService.findOne(name);
        if (user.isEmpty()) {
            log.info("User not found");
            return ResponseEntity.notFound().build();
        }
        log.info("Found user {}"+ user.get());

        String document = documentService.renderDocument(user.get());
        log.info("Rendered document [{}]"+ document);
        
        return user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}