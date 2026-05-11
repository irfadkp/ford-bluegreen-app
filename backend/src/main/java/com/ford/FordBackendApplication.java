package com.ford;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FordBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(FordBackendApplication.class, args);
    }
}
