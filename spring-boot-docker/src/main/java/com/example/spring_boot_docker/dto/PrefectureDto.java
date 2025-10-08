package com.example.spring_boot_docker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrefectureDto {
    @NotNull
    @Size(min = 1,max = 47)
    private Integer Id;
    @NotBlank
    @Size(max = 4)
    private String name;
}
