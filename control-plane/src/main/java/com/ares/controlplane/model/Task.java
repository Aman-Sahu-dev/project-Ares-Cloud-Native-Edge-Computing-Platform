package com.ares.controlplane.model;

import java.time.Instant;
import java.util.UUID;

public class Task {
    private final String id;
    private final String runtime;
    private final String entryPoint;
    private final String byteCode;
    private final Long memoryLimitBytes;
    private final Integer cpuShares;
    private final Instant submittedAt;
    private String status;

    public Task(String runtime, String entryPoint, String byteCode, Long memoryLimitBytes, Integer cpuShare){
        this.id = UUID.randomUUID().toString();
        this.entryPoint = entryPoint;
        this.runtime = runtime;
        this.byteCode = byteCode;
        this.memoryLimitBytes = memoryLimitBytes != null ? memoryLimitBytes:64*1024*1024;
        this.cpuShares = cpuShare != null ? cpuShare: 1024;
        this.status = "QUEUED";
        this.submittedAt = Instant.now();
    }
    public String getId() { return id; }
    public String getRuntime() { return runtime; }
    public String getEntryPoint() { return entryPoint; }
    public String getByteCode() { return byteCode; }
    public Long getMemoryLimitBytes() { return memoryLimitBytes; }
    public Integer getCpuShares() { return cpuShares; }
    public Instant getSubmittedAt() { return submittedAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
