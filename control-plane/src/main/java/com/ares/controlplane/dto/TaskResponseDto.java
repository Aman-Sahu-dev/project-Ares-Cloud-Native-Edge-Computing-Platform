package com.ares.controlplane.dto;

import java.time.Instant;

public record TaskResponseDto(
        String taskId,
        String runtime,
        String entryPoint,
        String status,
        String stdout,
        String stderr,
        String exitCode,
        Instant submittedAt
) {}