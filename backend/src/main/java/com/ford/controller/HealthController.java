package com.ford.controller;

import com.ford.service.LogGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
@Slf4j
public class HealthController {

    private final LogGeneratorService logGenerator;

    @GetMapping("/live")
    public ResponseEntity<Map<String, Object>> liveness() {
        logGenerator.logHeavily("Liveness probe check");
        
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "ford-backend");
        health.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(health);
    }

    @GetMapping("/ready")
    public ResponseEntity<Map<String, Object>> readiness() {
        logGenerator.logHeavily("Readiness probe check");
        
        Map<String, Object> health = new HashMap<>();
        health.put("status", "READY");
        health.put("service", "ford-backend");
        health.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(health);
    }
}
