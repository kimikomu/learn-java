package com.learn_java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HealthController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/health")
    public String health() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            return "Connected to: " + conn.getMetaData().getURL();
        }
    }
}
