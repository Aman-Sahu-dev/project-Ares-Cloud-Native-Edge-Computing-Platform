package com.ares.controlplane.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequestDto(
        @NotBlank(message = "Command cannot be empty")
        String entryPoint,
        @NotBlank
        String byteCode,
        String runtime,

        Long memoryLimitBytes,

        Integer cpuShares
) {}