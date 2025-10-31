package com.example.spring_boot_docker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HobbyDto {
    @NotNull
    private Integer hobbyId;
    @NotBlank
    private String hobbyName;
}
