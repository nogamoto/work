package com.example.spring_boot_docker.dto;

import java.sql.Blob;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    @NotBlank
    @Size(max = 128)
    private String name;
    private Integer ege;
    @Size(min = 0 , max = 1)
    private Integer sex;
    @Size(min = 1,max = 47)
    private Integer address1;
    @Size(max = 255)
    private String address2;
    private Integer hobby;
    @Size(max = 255)
    private String intro;
    private Blob image;
}