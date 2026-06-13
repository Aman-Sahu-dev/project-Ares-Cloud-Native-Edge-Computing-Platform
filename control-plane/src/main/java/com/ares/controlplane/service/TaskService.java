package com.ares.controlplane.service;

import com.ares.controlplane.dto.TaskRequestDto;
import com.ares.controlplane.dto.TaskResponseDto;
import com.ares.controlplane.model.Task;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);

    public TaskResponseDto submit(TaskRequestDto request){
        Task task = new Task(
                request.runtime(),
                request.entryPoint(),
                request.byteCode(),
                request.memoryLimitBytes(),
                request.cpuShares()
        );
        log.info("Task submitted: id ={}, runtime ={}, entrypoint={}",task.getId(),task.getRuntime(),task.getEntryPoint());
        return new TaskResponseDto(
                task.getId(),
                task.getRuntime(),
                task.getEntryPoint(),
                task.getStatus(),
                "",
                "",
                "",
                task.getSubmittedAt()
        );
    }
}
