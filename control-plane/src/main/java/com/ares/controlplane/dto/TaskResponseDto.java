package com.ares.controlplane.dto;

import java.time.Instant;

public record TaskResponseDto(
        String taskId,
        String command,
        String Status,
        String stdout,
        String stderr,
        String exitCode,
        Instant SubmittedAt
) {}
