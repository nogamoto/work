package com.example.spring_boot_docker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prefecture")
@Data
@NoArgsConstructor
public class Prefecture {
    @Id
    private Integer id;
    private String name;
}
