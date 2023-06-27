package com.vasyerp.hikariissue.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.vasyerp.hikariissue.models.User;


@Service
public class DocumentService {



    public String renderDocument(User user) throws InterruptedException {
        // slow render
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        return "Some document";
    }
}