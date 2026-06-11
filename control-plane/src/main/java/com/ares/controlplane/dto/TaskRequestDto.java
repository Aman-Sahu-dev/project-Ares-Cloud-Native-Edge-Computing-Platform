package com.ares.controlplane.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequestDto(
        @NotBlank(message = "Command cannot be empty")
        String command,

        String runtime,

        Long memoryLimitBytes,

        Integer cpuShares
) {}