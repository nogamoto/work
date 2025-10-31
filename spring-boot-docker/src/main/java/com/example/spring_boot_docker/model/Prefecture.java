package com.example.spring_boot_docker.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prefecture")
@Data
@NoArgsConstructor
public class Prefecture {
    @Id
    private Integer prefectureId;
    private String prefectureName;
    @OneToMany(mappedBy = "prefecture")
    private List<Employee> employees;

}
