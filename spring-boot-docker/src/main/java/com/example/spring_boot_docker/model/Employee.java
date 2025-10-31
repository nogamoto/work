package com.example.spring_boot_docker.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private Long employeeId;
    @Column(length = 10)
    private String name;
    private Integer ege;
    private Integer sex;
    @ManyToOne
    @JoinColumn(name = "prefectureId",nullable = false)
    private Prefecture prefecture;
    @Column(length = 255)
    private String address;
    @OneToMany(mappedBy = "employee")
    private List<Hobby> hobbies;
    @Column(length = 255)
    private String intro;
    @Lob
    private byte [] image;
}
