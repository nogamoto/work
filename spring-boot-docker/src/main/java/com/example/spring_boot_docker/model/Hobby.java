package com.example.spring_boot_docker.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "hobby")
@Entity
@Data
@NoArgsConstructor
public class Hobby {
    @Id
    private Integer hobbyId;
    private String hobbyName;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
