package com.ares.controlplane.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ExecuteController {
    @GetMapping("/health")
    public Map<String, String> health(){
        return Map.of("status" , "up", "service" , "control-plane");
    }
    @PostMapping("/api/execute")
    public Map<String,Object> execute(@RequestBody Map<String,String> request){
        String command = request.getOrDefault("command","none");
        return Map.of(
                "taskId","dummy" + System.currentTimeMillis(),
                "command",command,
                "status","queued",
                "stdout",""
        );
    }
}
