package com.example.spring_boot_docker.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employees")
@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_Id;
    @Column(length = 10)
    private String name;
    private Integer ege;
    private Integer sex;
    private Integer adress1;
    @Column(length = 255)
    private String adress2;
    private Integer hobby;
    @Column(length = 255)
    private String intro;
    private Blob image;
}
