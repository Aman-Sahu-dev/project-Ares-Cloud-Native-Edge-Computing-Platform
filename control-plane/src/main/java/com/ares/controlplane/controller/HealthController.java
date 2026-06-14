package com.ares.controlplane.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public Map<String,Object> health(){
        return Map.of(
                "status","UP",
                "service","ares-control-plane",
                "version","0.1.0",
                "timestamp", Instant.now().toString()
        );

    }

}
