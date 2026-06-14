package com.ares.controlplane.controller;

import com.ares.controlplane.dto.TaskRequestDto;
import com.ares.controlplane.dto.TaskResponseDto;
import com.ares.controlplane.service.TaskService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    private final TaskService taskService;

    public TaskController(TaskService service){
        this.taskService = service;
    }
    @PostMapping("/execute")
    public ResponseEntity<TaskResponseDto> execute(@Valid @RequestBody TaskRequestDto request){
        log.debug("Received execution request: runtime={}, entryPoint={}",request.runtime(),request.entryPoint());
        TaskResponseDto response = taskService.submit(request);
        return ResponseEntity.accepted().body(response);
    }
}
